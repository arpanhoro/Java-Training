package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.exception.DuplicateEmailException;
import com.springdemo.exception.EmployeeNotFoundException;
import com.springdemo.model.Employee;
import com.springdemo.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployeeById(int id)   
	{  
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id :" + id));
		return employee;
	} 
	
	public Employee saveEmployee(Employee employee){
		if (employeeRepository.isEmailIdAlreadyInUse(employee.getEmailId())) {
			throw new DuplicateEmailException("Email Id " + employee.getEmailId() + " is already in use");
		}
		return employeeRepository.save(employee); 
	}
	
	public Employee updateEmployee(int id,Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not exist with id :" + id));
		if (employeeRepository.isEmailIdAlreadyInUseByOtherEmployee(employee.getId(), employee.getEmailId())) {
			throw new DuplicateEmailException("Email Id " + employee.getEmailId() + " is already in use by another employee");
		}
		/*employee.setId(employeeDetails.getId());*/
		employee.setName(employeeDetails.getName());
		employee.setDateOfBirth(employeeDetails.getDateOfBirth());
		employee.setAddress(employeeDetails.getAddress());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setSalary(employeeDetails.getSalary());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
}
