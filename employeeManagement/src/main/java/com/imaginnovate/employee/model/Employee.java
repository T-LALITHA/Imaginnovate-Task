package com.imaginnovate.employee.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeID;

	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;

	@Column(unique = true,nullable = false)
	private String email;

	@ElementCollection
	@CollectionTable(name = "PhoneNumber",joinColumns = @JoinColumn(name = "employeeID"))
	@Column(name = "phno")
	private Set<String> phoneNumber;

	@Column(nullable = false)
	private LocalDate doj;
	
	@Column(nullable = false)
	private Double salaryPerMonth;

	public Employee(Long employeeID, String firstName, String lastName, String email, Set<String> phoneNumber,
			LocalDate doj, Double salaryPerMonth) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salaryPerMonth = salaryPerMonth;
	}

	public Employee() {
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

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(Double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", doj=" + doj + ", salaryPerMonth=" + salaryPerMonth + "]";
	}

	
	
	
	
	

}
