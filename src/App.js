import "./App.css";

import { BrowserRouter as Router } from "react-router-dom";
import { Routes, Route } from "react-router";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponents from "./components/ListEmployeeComponents";
import AddEmployeeComponent from "./components/AddEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route path="/" exact element={<ListEmployeeComponents />}></Route>
            <Route
              path="/employees"
              element={<ListEmployeeComponents />}
            ></Route>
            <Route
              path="/add-employee"
              element={<AddEmployeeComponent />}
            ></Route>
            <Route
              path="/edit-employee/:id"
              element={<AddEmployeeComponent />}
            ></Route>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}
// <button className="btn btn-primary" onClick={this.addEmployee}>Add Employee</button>
export default App;
