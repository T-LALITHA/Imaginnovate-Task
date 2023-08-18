package com.imaginnovate.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException{

	private String message;
	
	

	public String getMessage() {
		return message;
	}


	public EmployeeAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	
	public EmployeeAlreadyExistsException() {
		
	}
	
	
}
