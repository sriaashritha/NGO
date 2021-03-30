package com.ngo.cg.exception;

public class DuplicateAdminException extends Exception {
private static final long serialVersionUID = 1L;
	
	public DuplicateAdminException(String errorMessage) {
		super(errorMessage);
	}

}