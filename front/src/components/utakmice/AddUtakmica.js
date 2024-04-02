import React, { useEffect, useState } from "react"
import { Button, Col, Container, Form, Row } from 'react-bootstrap';
import TestAxios from "../../apis/TestAxios";
import { useNavigate} from 'react-router-dom';



const DodavanjeUtakmice = () => {


  let utakmicaInit = {
    repA: "",
    repB: "",
    goloviA: 0,
    goloviB: 0
  }

  const [utakmica, setUtakmica] = useState(utakmicaInit)
  const [repke, setRepke] = useState([])

  const navigate = useNavigate()

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
  

  useEffect(()=>{
    getRepke();
  }, [])


  const renderRepke = () => {
    return repke.map((repka) => {
      return <option key={repka.id} value={repka.id}>{repka.skraceniNaziv}</option>
    })
  }


  const repAChange = (e) => {
    setUtakmica({
      repA: e.target.value,
      repB: utakmica.repB,
      goloviA: utakmica.goloviA,
      goloviB: utakmica.goloviB
    })
  }

  const repBChange = (e) => {
    setUtakmica({
      repA: utakmica.repA,
      repB: e.target.value,
      goloviA: utakmica.goloviA,
      goloviB: utakmica.goloviB
    })
    
  }

  

  const addUtakmica = () => {
      // console.log(utakmica);
     let params = {
      'reprezentacijaAId': utakmica.repA,
      'reprezentacijaBId': utakmica.repB,
        'goloviA': utakmica.goloviA,
        'goloviB': utakmica.goloviB

      }

    TestAxios.post("/utakmice", params)
    .then(res=> {
      console.log(res.data);
      alert("Dodavanje uspesno!")
      navigate("/utakmice")
    })
    .catch(error=> {
      if(error.response.status === 405) {
        alert("Morate uneti dve razlicite reprezentacije!")
      }
      console.log(error);
    })


  }



return(
  <Container fluid className="bg-image2" style={{ padding: "10px" }}> 
<Col>


  <Row >
    <Col>
      <Form.Group>
        <Form.Label>Reprezentacija A</Form.Label>
        <Form.Control type="select" as="select" name="repA" style={{ width: "100%" }} onChange={repAChange}>
          <option value="null"></option>
          {renderRepke()}
        </Form.Control>
      </Form.Group>
    </Col>
    <Col>
      <Form.Group>
        <Form.Label>Reprezentacija B</Form.Label>
        <Form.Control type="select" as="select" name="repB" style={{ width: "100%" }} onChange={repBChange}>
          <option value="null"></option>
          {renderRepke()}
        </Form.Control>
      </Form.Group>
    </Col>
  </Row>

  <Row>
    <Col style={{marginTop:"10px"}}>
      <Form.Group>
        <Button onClick={() => addUtakmica()}>Dodaj utakmicu</Button>
      </Form.Group>
    </Col>
  </Row>
</Col>
</Container>
)

}


export default DodavanjeUtakmice