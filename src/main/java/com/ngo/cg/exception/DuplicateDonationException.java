package com.ngo.cg.exception;

public class DuplicateDonationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DuplicateDonationException(String errorMessage) {
		super(errorMessage);

	}

}