import { jwtDecode } from "jwt-decode";
import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Container, Form, Row } from 'react-bootstrap';
import { useNavigate} from 'react-router-dom'
import TestAxios from "../../apis/TestAxios";


const Utakmice = (props) => {


  const token = localStorage.getItem("jwt");
  const decoded = token ? jwtDecode(token) : null;
  const isAdmin = decoded?.role?.authority === "ROLE_ADMIN";

  
  const[pageNo, setPageNo] = useState(0);
  const[maxPages, setMaxPages] = useState(0)
  const[utakmice, setUtakmice] = useState([])  
  const [repke, setRepke] = useState([])
  const [searchParams, setSearchParams] = useState({
    repA: '',
    repB: ''
  })

  const navigate = useNavigate()


  const goToAdd = () => {
    navigate("/utakmice/add");
  }


  const getUtakmice = useCallback(() => {
    TestAxios.get(`/utakmice?pageNo=${pageNo}`, {params: {
      repAId: searchParams.repA,
      repBId: searchParams.repB
    }})
     .then(res => {
      console.log(res.data);
      setMaxPages(res.headers["total-pages"])
      setUtakmice(res.data);  
    })
    .catch(error => {
      
      if(error.response.status==405){
        alert("Morate uneti dve razlicite reprezentacije!");
      }
      console.log(error.data);
    });
  }, [searchParams, pageNo])

  const getRepke = () => {
    TestAxios.get("/repke")
    .then(res=> {
      console.log(res.data);
      setRepke(res.data)
    })
    .catch(error=> {
      console.log(error);
    })

  }





  useEffect(() => {
    getUtakmice()    
  }, [pageNo, searchParams])

  useEffect(()=>{
    getRepke()
  },[])

  
  const renderRepke = () => {
    return repke.map((repka) => {      
      return <option key={repka.id} value={repka.id}>{repka.skraceniNaziv}</option>   
    })
  }


  const handleDelete = useCallback((utakmicaId) => {
    TestAxios.delete("/utakmice/" + utakmicaId)
    .then(res=>{
      console.log("Uspesno brisanje!");
      getUtakmice();
    })
    .catch(error=>{
      alert("Error!")
    });
  }, []);


  const updateGoalA = (utakmicaId, repAId) => {

    console.log(repAId);

    TestAxios.put("/utakmice/goala/"+ utakmicaId, {
      Headers:{'Content-Type': 'application/json'
      }
      })
    .then(res=>{      
      console.log(res.data);
      navigate("/gol/"+repAId);
    })
    .catch(error=>{
      alert("Error!")
      console.log(error);
    })
  }


  const updateGoalB = (utakmicaId, repBId) => {
   console.log(repBId);
    TestAxios.put("/utakmice/goalb/"+ utakmicaId, {
      Headers:{'Content-Type': 'application/json'
      }
      })
    .then(res=>{

      console.log(res.data);
      navigate("/gol/"+repBId);
    })
    .catch(error=>{
      alert("Error!")
      console.log(error);
    })
  }


 


  const renderUtakmice = () => {
    return utakmice.map((utakmica, i)=> {
      return(
        <tr key ={utakmica.id}>
          <td>{utakmica.repANaziv}</td>
          <td>{utakmica.repBNaziv}</td>
          <td>{utakmica.goloviA}</td>
          <td>{utakmica.goloviB}</td>
          { isAdmin?
          <td>
      
          <Button style={{margin:"4px"}} onClick={() => updateGoalA(utakmica.id, utakmica.reprezentacijaAId)}>A + 1</Button>
          <Button style={{margin:"4px"}} onClick={() => updateGoalB(utakmica.id, utakmica.reprezentacijaBId)}>B + 1</Button>
          <Button onClick={() => handleDelete(utakmica.id)}>Obriši</Button>
         </td>
          :
          <br />
          }
          </tr>
      )
    })
  }

  const handleChange = (e) => {
    const { name, value } = e.target;const 
    newValue = value === "null" ? null : value; 
    setSearchParams({ ...searchParams, [name]: newValue });
  }

  const handleSearch = () => {
    getUtakmice()
  }


return(
  <Container fluid className="bg-image1" style={{ padding: "10px" }}>
  <Row>
    <Col>
  
      <Row>
        <Col>
          <Form.Group>
            <Form.Label>Reprezentacija A</Form.Label>
            <Form.Control type="select" as="select" name="repA" style={{ width: "25%" }} onChange={handleChange}>
              <option value="null"></option>
              {renderRepke()}
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Reprezentacija B</Form.Label>
            <Form.Control type="select" as="select" name="repB" style={{ width: "25%" }} onChange={handleChange}>
              <option value="null"></option>
              {renderRepke()}
            </Form.Control>
          </Form.Group>
        </Col>
      </Row>
    </Col>
  </Row>

  <Row>
    <Col style={{marginTop: "15px"}}>
      <div style={{ display: 'flex', justifyContent: "space-between", marginBottom: "10px" }}>
        {isAdmin ?
          <Button onClick={goToAdd}>Nova utakmica</Button>
          :
          <br />
        }
        <span>
          <Button disabled={pageNo <= 0} className="button button-navy" style={{ marginRight: "5px" }} onClick={() => { setPageNo(pageNo - 1) }}>Prethodna</Button>
          <Button disabled={pageNo >= maxPages - 1} className="button button-navy" onClick={() => { setPageNo(pageNo + 1) }}>Sledeća</Button>
        </span>
      </div>
    </Col>
  </Row>

  <Row>
    <Col>
      <table className="table">
        <thead>
          <tr>
            <th>Reprezentacija A</th>
            <th>Reprezentacija B</th>
            <th>Golovi A</th>
            <th>Golovi B</th>
        

          </tr>
        </thead>
        <tbody>
          {renderUtakmice()}
        </tbody>
      </table>
    </Col>
  </Row>
</Container>
)
}

export default Utakmice