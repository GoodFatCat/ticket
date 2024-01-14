package com.github.goodfatcat.eventservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsupportedFileException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UnsupportedFileException() {
		super();
	}

	public UnsupportedFileException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnsupportedFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedFileException(String message) {
		super(message);
	}

	public UnsupportedFileException(Throwable cause) {
		super(cause);
	}

}
