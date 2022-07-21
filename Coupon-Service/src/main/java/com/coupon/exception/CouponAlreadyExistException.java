package com.coupon.exception;

public class CouponAlreadyExistException extends RuntimeException {

	public CouponAlreadyExistException() {
		super();

	}

	public CouponAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CouponAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public CouponAlreadyExistException(String message) {
		super(message);

	}

	public CouponAlreadyExistException(Throwable cause) {
		super(cause);

	}

}
