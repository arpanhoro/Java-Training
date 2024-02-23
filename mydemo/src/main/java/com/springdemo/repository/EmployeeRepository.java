package com.springdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	public default boolean isEmailIdAlreadyInUse(String emailId) {
		return true;
	}

	public default boolean isEmailIdAlreadyInUseByOtherEmployee(int currentEmployeeId, String emailId) {
		return true;
	}

}
