package com.night.crud_springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.night.crud_springboot.exceptions.ResourceNotFoundException;
import com.night.crud_springboot.model.Employee;
import com.night.crud_springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// get all employee
	@GetMapping
	public List<Employee> getAllEmployees() {
//		System.err.println("getAllEmpoyees method called");
		return employeeRepository.findAll();
	}

	// CREATE EMPLOYEE REST API
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
//		System.out.println(employee);
//		System.err.println("createEmployee method called");
		return employeeRepository.save(employee);
	} 

	// GET EMPLOYEE BY ID
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with id" + id));

		return ResponseEntity.ok(employee);
	}

	// UPDATE EMPLOYEE
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with id:" + id));

		updateEmployee.setFirstName(employeeDetails.getFirstName());
		updateEmployee.setLastName(employeeDetails.getLastName());
		updateEmployee.setEmailId(employeeDetails.getEmailId());

		employeeRepository.save(updateEmployee);

		return ResponseEntity.ok(updateEmployee);
	}

	// DELETE EMPLOYEE
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with id:" + id));

		employeeRepository.delete(employee);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
