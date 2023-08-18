package com.imaginnovate.employee.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.employee.exception.EmployeeAlreadyExistsException;
import com.imaginnovate.employee.exception.ResourceNotFoundException;
import com.imaginnovate.employee.model.Employee;
import com.imaginnovate.employee.payload.EmployeeDto;
import com.imaginnovate.employee.payload.EmployeeTaxDeduction;
import com.imaginnovate.employee.repository.EmployeeRepository;
import com.imaginnovate.employee.serviceI.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

		logger.info("Entered saveEmployee() in Service Implementation");

		Employee employee = this.modelMapper.map(employeeDto, Employee.class);

		Employee emp = null;

		try {

			emp = employeeRepository.save(employee);

		} catch (Exception e) {

			logger.error("EmployeeAlreadyExistsException occured");

			throw new EmployeeAlreadyExistsException("Employee already exists");
		}

		return this.modelMapper.map(emp, EmployeeDto.class);

	}

	@Override
	public EmployeeTaxDeduction deductionsForCurrentFY(Long id) {

		logger.info("Entered deductionsForCurrentFY() in Service Implementation");

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with given ID"));

		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);

		LocalDate joiningDate = employeeDto.getdOJ();

		int joiningMonth = joiningDate.getMonthValue();

		int joiningYear = joiningDate.getYear();

		Double employeeSalaryPerMonth = employeeDto.getSalaryPerMonth();

		LocalDate currentDate = LocalDate.now();

		int currentMonth = currentDate.getMonthValue();

		int previousFYEndYear = currentMonth <= 3 
				                ? currentDate.getYear() - 1 
				                : currentDate.getYear() ;

		Double totalsalary = 0.0;
		
		if (joiningYear <= previousFYEndYear && joiningMonth <= 3) {

			totalsalary = 12 * employeeSalaryPerMonth;

		} else {

			LocalDate lastDateOfFY = joiningMonth <= 3 
					       ? LocalDate.of(joiningYear, 3, 31) 
					       : LocalDate.of(joiningYear + 1, 3, 31);

			Period period = Period.between(joiningDate, lastDateOfFY);

			totalsalary = period.getMonths() * employeeSalaryPerMonth
					+ (period.getDays() / 30) * employeeSalaryPerMonth;

		}
		
		Double tax = 0.0;
		Double cess = 0.0;

		if (totalsalary > 250000 && totalsalary <= 500000) {

			tax = (totalsalary - 250000) * 0.05;

		} else if (totalsalary > 500000 && totalsalary <= 1000000) {
			
			tax = 12500 + (totalsalary - 500000) * 0.1;
			
		} else if (totalsalary > 1000000) {

			tax = 112500 + (totalsalary - 1000000) * 0.2;
		}

		if (totalsalary > 2500000) {
			
			cess = (totalsalary - 2500000) * 0.02;
		}

		EmployeeTaxDeduction employeeTaxDeduction = new EmployeeTaxDeduction();

		employeeTaxDeduction.setEmployeeID(employeeDto.getEmployeeID());
		employeeTaxDeduction.setFirstName(employeeDto.getFirstName());
		employeeTaxDeduction.setLastName(employeeDto.getLastName());
		employeeTaxDeduction.setAnnualSalary(employeeDto.getSalaryPerMonth() * 12);
		employeeTaxDeduction.setTotalTax(tax);
		employeeTaxDeduction.setTotalCess(cess);

		return employeeTaxDeduction;

	}

}
