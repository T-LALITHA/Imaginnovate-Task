package com.imaginnovate.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomizedExceptionHandler{

	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<Object> EmployeeAlreadyExistsExceptionHandler(EmployeeAlreadyExistsException exception,
																		WebRequest webRequest){
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> ResourceNotFoundExceptionHandler(ResourceNotFoundException exception,
																		WebRequest webRequest){
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}
