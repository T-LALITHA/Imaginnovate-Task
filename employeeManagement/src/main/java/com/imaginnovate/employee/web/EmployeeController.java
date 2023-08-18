package com.imaginnovate.employee.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.employee.payload.EmployeeDto;
import com.imaginnovate.employee.payload.EmployeeTaxDeduction;
import com.imaginnovate.employee.serviceI.EmployeeServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceI employeeService;
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto,BindingResult errors){
		
		logger.info("Entered saveEmployee() in EmployeeController");

		if (errors.hasErrors()) {
			Map<String, String> errorDetails = new HashMap<>();
			for (FieldError error : errors.getFieldErrors()) {
				errorDetails.put(error.getField(), error.getDefaultMessage());
				
				logger.error("Validation error :" + error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorDetails, HttpStatus.BAD_REQUEST);

		} else {

			EmployeeDto employee = employeeService.saveEmployee(employeeDto);
			return new ResponseEntity<EmployeeDto>(employee, HttpStatus.CREATED);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeTaxDeduction> taxDeductionCurrentYear(@PathVariable Long id){
		
		logger.info("Entered taxDeductionCurrentYear() in EmployeeController");

		return new ResponseEntity<EmployeeTaxDeduction>(employeeService.deductionsForCurrentFY(id),HttpStatus.OK);
		
	}
	
}
