package com.coupon.exception;

public class CouponNotFoundException extends RuntimeException {

	public CouponNotFoundException() {
		super();

	}

	public CouponNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CouponNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CouponNotFoundException(String message) {
		super(message);

	}

	public CouponNotFoundException(Throwable cause) {
		super(cause);

	}

}
