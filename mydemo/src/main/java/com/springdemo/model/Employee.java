package com.springdemo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "emp")
public class Employee {

	@Id
	@Column(name = "empid")
	@NotNull(message = "Id is mandatory")
	@Min(1)
	private int id;
	
	@Column(name = "empname")
	@NotBlank(message = "Name is mandatory")
	@Size(max = 50, message = "Max value is 50")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must not contain any number or special characters")
	private String name;
	
	@Column(name = "empdob")
	@NotNull(message = "Date of Birth is mandatory")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@Column(name = "empaddress")
	@NotBlank(message = "Address is mandatory")
	@Size(max = 100, message = "Max value is 100")
	private String address;
	
	@Column(name = "empemail")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be correct format")
	private String emailId;
	
	@Column(name = "empsalary")
	@NotNull(message = "Salary is mandatory")
	@Digits(fraction=2, integer = 10)
	private int salary;
	
	public Employee() {
		
	}
	
	
	public Employee(@NotNull(message = "Id is mandatory") @Min(1) int id,
			@NotBlank(message = "Name is mandatory") @Size(max = 50, message = "Max value is 50") @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must not contain any number or special characters") String name,
			@NotNull(message = "Date of Birth is mandatory") Date dateOfBirth,
			@NotBlank(message = "Address is mandatory") @Size(max = 100, message = "Max value is 100") String address,
			@NotBlank(message = "Email is mandatory") @Email(message = "Email should be correct format") String emailId,
			@NotNull(message = "Salary is mandatory") @Digits(fraction = 2, integer = 10) int salary) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.emailId = emailId;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}
