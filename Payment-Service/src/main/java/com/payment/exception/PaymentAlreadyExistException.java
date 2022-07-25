package com.payment.exception;

public class PaymentAlreadyExistException extends RuntimeException {

	public PaymentAlreadyExistException() {
		super();

	}

	public PaymentAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public PaymentAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public PaymentAlreadyExistException(String message) {
		super(message);

	}

	public PaymentAlreadyExistException(Throwable cause) {
		super(cause);

	}

}
