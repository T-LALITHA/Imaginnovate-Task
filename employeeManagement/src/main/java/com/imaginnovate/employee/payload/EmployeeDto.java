package com.imaginnovate.employee.payload;

import java.time.LocalDate;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

	private Long employeeID;
	
	@NotEmpty(message = "FirstName is Required")
	private String firstName;
	
	@NotEmpty(message = "LastName is Required")
	private String lastName;
	
	@Email
	@NotEmpty(message = "Email is Required")
	private String email;
	
	private Set<String> phoneNumber;
	
	@NotNull(message = "Date of joining is Required")
	private LocalDate dOJ;
	
	@NotNull(message = "Salary is Required")
	private Double salaryPerMonth;

	public EmployeeDto(Long employeeID, @NotEmpty(message = "FirstName is Required") String firstName,
			@NotEmpty(message = "LastName is Required") String lastName,
			@Email @NotEmpty(message = "Email is Required") String email, Set<String> phoneNumber,
			@NotNull(message = "Date of joining is Required") LocalDate dOJ,
			@NotNull(message = "Salary is Required") Double salaryPerMonth) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dOJ = dOJ;
		this.salaryPerMonth = salaryPerMonth;
	}
	
	

	public EmployeeDto(@NotEmpty(message = "FirstName is Required") String firstName,
			@NotEmpty(message = "LastName is Required") String lastName,
			@Email @NotEmpty(message = "Email is Required") String email, Set<String> phoneNumber,
			@NotNull(message = "Date of joining is Required") LocalDate dOJ,
			@NotNull(message = "Salary is Required") Double salaryPerMonth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dOJ = dOJ;
		this.salaryPerMonth = salaryPerMonth;
	}



	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Set<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getdOJ() {
		return dOJ;
	}

	public void setdOJ(LocalDate dOJ) {
		this.dOJ = dOJ;
	}

	public Double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(Double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", dOJ=" + dOJ + ", salaryPerMonth="
				+ salaryPerMonth + "]";
	}
	
	
	
	
	
}
