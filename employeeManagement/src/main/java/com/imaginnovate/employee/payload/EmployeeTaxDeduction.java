package com.imaginnovate.employee.payload;

public class EmployeeTaxDeduction {

	private Long employeeID;
	private String firstName;
	private String lastName;
	private Double annualSalary;
	private Double totalTax;
	private Double totalCess;
	
	public EmployeeTaxDeduction(Long employeeID, String firstName, String lastName, Double annualSalary,
			Double totalTax, Double totalCess) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.totalTax = totalTax;
		this.totalCess = totalCess;
	}
	public EmployeeTaxDeduction() {
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
	public Double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public Double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}
	public Double getTotalCess() {
		return totalCess;
	}
	public void setTotalCess(Double totalCess) {
		this.totalCess = totalCess;
	}
	
	
}
