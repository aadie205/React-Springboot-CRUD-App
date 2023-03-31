package com.night.crud_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.night.crud_springboot.model.Employee;
import com.night.crud_springboot.repository.EmployeeRepository;

@SpringBootApplication
public class CrudSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);
		System.err.println("Spring boot application started");
	}

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args)throws Exception{
		Employee employee =new Employee();
		
		employee.setFirstName("Aditya");
		employee.setLastName("Yadav");
		employee.setEmailId("yadavaditya205@gmail.com");
		
//		employeeRepository.save(employee);
		
		Employee employee1 =new Employee();
		
		employee1.setFirstName("Naveen");
		employee1.setLastName("Kumar");
		employee1.setEmailId("naveenroy@gmail.com");
		
//		employeeRepository.save(employee1);
	}
}
