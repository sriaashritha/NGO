package com.ngo.cg.exception;

public class NoSuchEmployeeException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchEmployeeException(String errorMessage) {
		super(errorMessage);
	}
	
}
