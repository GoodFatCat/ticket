package com.github.goodfatcat.eventservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmptyFileException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EmptyFileException() {
		super();
	}

	public EmptyFileException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyFileException(String message) {
		super(message);
	}

	public EmptyFileException(Throwable cause) {
		super(cause);
	}

}
