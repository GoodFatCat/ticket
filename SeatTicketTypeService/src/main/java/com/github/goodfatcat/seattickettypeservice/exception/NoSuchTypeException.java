package com.github.goodfatcat.seattickettypeservice.exception;

public class NoSuchTypeException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoSuchTypeException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchTypeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
