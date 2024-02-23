package com.springdemo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.springdemo.service.EmployeeService;
import com.springdemo.exception.DuplicateEmailException;
import com.springdemo.exception.EmployeeNotFoundException;
import com.springdemo.model.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id)  
	{  
		try {
			Employee employee = employeeService.getEmployeeById(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	} 
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee){
		try {
			employeeService.saveEmployee(employee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DuplicateEmailException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails)
	{
		try {
			employeeService.updateEmployee(id, employeeDetails);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (DuplicateEmailException | EmployeeNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
