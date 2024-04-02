import React, { useEffect, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import TestAxios from "../../apis/TestAxios";

const Gol = () => {


  const[igraci, setIgraci] = useState([]);
  const[igrac, setIgrac] = useState({
    id: 0
  })
  
  const routeParams = useParams();
  const repId = routeParams.id;

  const navigate = useNavigate();



  useEffect(()=>{
    getIgraci()
  }, [])

  const getIgraci = () => {
    TestAxios.get("/igraci/"+repId)
    .then(res=>{
      console.log(res.data);
      setIgraci(res.data);
    })
    .catch(error=>{
      console.log(error);
    })
  }

const renderIgraci = () => {
  return igraci.map((igrac) => {      
    return <option key={igrac.id} value={igrac.id}>{igrac.ime+ " "}{igrac.prezime}</option>   
  })  
}

const onIdChange = (e) => {
  console.log(e.target.value);

  setIgrac({ id: e.target.value});
}

const addGoal = (igracId) => {
  console.log(igracId);
  TestAxios.put("/igraci/"+igracId,{
    Headers:{'Content-Type': 'application/json'
    }
    })
  .then(res=>{
    console.log(res.data);
    alert("Gol dodat");
    navigate("/utakmice");
  })
  .catch(error=>{
    console.log(error);
    alert("Error!")
  })

}

return(
  <Container fluid className="bg-image3" style={{ padding: "10px" }}>  
  <Form>
<Form.Group> 
  <Form.Label>Strelac gola:</Form.Label>
                <Form.Control type="select" as="select"  name="repB" style={{ width: "25%" }} onChange={onIdChange} >
                <option value="null"></option>
            {renderIgraci()}
            </Form.Control>
              </Form.Group>
              <div container='container' style={{ display: 'flex'}}>
                <Button onClick={() => addGoal(igrac.id)}style={{marginTop:'10px'}} className="btn btn-primary"  >Dodaj gol</Button>
            </div>
  </Form>
  </Container>
)

}

export default Gol;