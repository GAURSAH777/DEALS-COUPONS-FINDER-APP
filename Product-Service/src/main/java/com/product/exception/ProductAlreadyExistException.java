package com.product.exception;

public class ProductAlreadyExistException extends RuntimeException {

	public ProductAlreadyExistException() {
		super();

	}

	public ProductAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ProductAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductAlreadyExistException(String message) {
		super(message);

	}

	public ProductAlreadyExistException(Throwable cause) {
		super(cause);

	}

}
