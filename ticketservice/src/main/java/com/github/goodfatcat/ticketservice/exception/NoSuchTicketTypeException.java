package com.github.goodfatcat.ticketservice.exception;

public class NoSuchTicketTypeException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoSuchTicketTypeException() {
		// TODO Auto-generated constructor stub
	}

	public NoSuchTicketTypeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTicketTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTicketTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchTicketTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
