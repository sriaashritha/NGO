package com.ngo.cg.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ngo.cg.exception.DuplicateAdminException;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateEmployeeException;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchAdminException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.exception.NoSuchNeedyPeopleException;



@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(value = {NoSuchNeedyPeopleException.class,NoSuchNeedyPeopleException.class})
	public ResponseEntity<Object> handleNotFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {DuplicateNeedyPersonException.class,DuplicateNeedyPersonException.class})
	public ResponseEntity<Object>  handleDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}

	
	@ExceptionHandler(value = {DuplicateDonationException.class,DuplicateDonationException.class})
	public ResponseEntity<Object>  handleDonationDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {NoSuchEmployeeException.class,NoSuchEmployeeException.class})
	public ResponseEntity<Object> handleNoEmployeeFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = {DuplicateAdminException.class,DuplicateAdminException.class})
	public ResponseEntity<Object>  handleAdminDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = {DuplicateEmployeeException.class,DuplicateEmployeeException.class})
	public ResponseEntity<Object>  handleEmployeeDuplicateExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value = {NoSuchAdminException.class,NoSuchAdminException.class})
	public ResponseEntity<Object> handleNoAdminFoundExceptions(Exception exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
}