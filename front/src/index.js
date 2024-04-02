import React from 'react';
import { createRoot } from 'react-dom/client';
import {Link, Route,BrowserRouter as Router, Routes} from 'react-router-dom';
import Home from './components/Home';
import NotFound from './components/NotFound';
import Login from './components/authorization/Login';
import { logout } from './services/auth';
import { Button, Nav, Navbar, NavbarBrand ,Container} from 'react-bootstrap';
import AddUtakmica from './components/utakmice/AddUtakmica';
import Utakmice from './components/utakmice/Utakmice';
import Gol from './components/golovi/Gol';
import ListaStrelaca from './components/igraci/ListaStrelaca';



const App = () => {

    if(window.localStorage['jwt']){
        return( 
        
                <Router>

                <Navbar expand bg="dark" variant='dark'>   

                    <NavbarBrand as={Link} to="/"> Home </NavbarBrand>  

                    <NavbarBrand as={Link} to="/utakmice"> Utakmice </NavbarBrand>  
                    <NavbarBrand as={Link} to="/strelci"> Lista strelaca </NavbarBrand> 
                    <Nav>
                        <Button onClick={()=>logout()} >Logout</Button>
                    </Nav>
                </Navbar>
    
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />      
                    <Route path='/login' element={<Login/>} />
                    <Route path='/utakmice'  element={<Utakmice/>}/>
                    <Route path='/utakmice/add'  element={<AddUtakmica/>}/>
                    <Route path='/strelci'  element={<ListaStrelaca/>}/>
                    <Route path='/gol/:id'  element={<Gol/>}/>
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
                </Container>
                </Router>
    
    
        )
    }else{
        return( 
          
                <Router>

                <Navbar expand bg="dark" variant='dark'> 
                     <NavbarBrand as={Link} to="/"> Test </NavbarBrand>  
                    <NavbarBrand as={Link} to="/utakmice"> Utakmice </NavbarBrand>       
                     <Nav.Link as={Link} to="/login" >Login</Nav.Link>
                </Navbar>
                
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />      
                    <Route path='/login' element={<Login/>} />
                    <Route path='/utakmice'  element={<Utakmice/>}/>
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
  		</Container>
                </Router>
    
    
        
    
        )
    }

    

};


const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);
 
