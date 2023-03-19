import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router} from "react-router-dom";
import { Link } from 'react-router-dom'
import {Routes, Route} from "react-router";
import ListEmployeeComponents from './components/ListEmployeeComponents';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';

function App() {
  return (
    
    <div>
    <Router>
           <HeaderComponent /> 
            <div className="container">
                 <Routes>
                       <Route path = "/" exact  element={<ListEmployeeComponents/>}></Route>
                       <Route path = "/employee" element={<ListEmployeeComponents/>}></Route>
                       <Route path = "/add-employee" element={<CreateEmployeeComponent/>}></Route>
                 </Routes>
            </div>
            <FooterComponent/>
   </Router>
  </div>
  );
}

export default App;
