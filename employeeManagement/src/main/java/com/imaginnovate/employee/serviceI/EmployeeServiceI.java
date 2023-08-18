package com.imaginnovate.employee.serviceI;

import com.imaginnovate.employee.payload.EmployeeDto;
import com.imaginnovate.employee.payload.EmployeeTaxDeduction;

public interface EmployeeServiceI {


	EmployeeDto saveEmployee( EmployeeDto employeeDto);

	EmployeeTaxDeduction deductionsForCurrentFY(Long id);


}
