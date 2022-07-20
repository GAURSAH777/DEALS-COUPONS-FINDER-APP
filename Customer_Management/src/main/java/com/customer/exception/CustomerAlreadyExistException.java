package com.customer.exception;

public class CustomerAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistException(String msg) {
		super(msg);
	}

}
