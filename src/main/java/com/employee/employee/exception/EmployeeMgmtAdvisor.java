package com.employee.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeMgmtAdvisor {

	@ExceptionHandler(EmployeeMgmtException.class)
	public ResponseEntity<Object> handleEmpException(EmployeeMgmtException exception){
		
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		
	}
}
