import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const ListEmployeeComponents = () => {
  const [employees, setEmployees] = useState([]);
  // console.log("employee at line no 6: ",employees); //emp value is: []
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    getAllEmployees();
  }, [refresh]);

  const getAllEmployees = () => {
    EmployeeService.getEmployees()
      .then((res) => {
        console.log("got res:", res.data);
        setEmployees(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const deleteEmployee = (employeeId) => {
    EmployeeService.deleteEmployee(employeeId)
      .then((Response) => {
        getAllEmployees();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const refreshKro = () => {
    setRefresh(!refresh);
  };

  // console.log("employee is: ", employees);

  return (
    <div classsName="container">
      <h2 className="text-center">Employees List</h2>

      <Link to="/add-employee" className="btn btn-primary mb-2">
        Add Employee
      </Link>

      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Employee id</th>
              <th>Employee First Name</th>
              <th>Employee last Name</th>
              <th>Employee email</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.emailId}</td>
                <td>
                  <Link
                    className="btn btn-info"
                    to={`/edit-employee/${employee.id}`}
                  >
                    Update
                  </Link>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteEmployee(employee.id)}
                    style={{ marginLeft: "10px" }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <button onClick={refreshKro}> Refresh</button>
      </div>
    </div>
  );
};

export default ListEmployeeComponents;
