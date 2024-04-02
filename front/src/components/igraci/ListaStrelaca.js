import React, { useEffect, useState } from "react";
import { Container} from 'react-bootstrap';
import TestAxios from "../../apis/TestAxios";

const ListaStrelaca = () => {

  const [strelci, setStrelci] = useState([]);

  const getStrelci = () => {
    TestAxios.get("/igraci/strelci")
    .then(res=>{
      console.log(res.data);
      setStrelci(res.data);
    })
    .catch(error=>{
      console.log(error);
    })
  }

  useEffect(()=>{
    getStrelci()
  }, []);



  const renderStrelci = () => {
      return strelci.map((el, i) => {
        return(
          <tr key ={el.id}>
          <td>{el.ime}</td>
          <td>{el.prezime}</td>
          <td>{el.postignutiGolovi}</td>          
          <td>{el.reprezentacijaNaziv}</td>
          </tr>
        )
      })
  }
  
  return(
    <Container fluid className="bg-image4" style={{ padding: "10px" }}>
      <table className="tableStrelci">
       
        <tbody className="tbody1">
          {renderStrelci()}
        </tbody>
      </table>


    </Container>
  )

}

export default ListaStrelaca;