package com.github.goodfatcat.seattickettypeservice.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.github.goodfatcat.seattickettypeservice.dto.ExceptionResponse;
import com.github.goodfatcat.seattickettypeservice.exception.NoSuchTypeException;
import com.github.goodfatcat.seattickettypeservice.exception.NoTypesException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {NoSuchTypeException.class,
			NoTypesException.class})
	public ResponseEntity<?> handleException(RuntimeException exception,
			HttpServletRequest servletRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setPath(servletRequest.getRequestURI());
		exceptionResponse.setError("Bad request");
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setStatus(400);
		exceptionResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.badRequest().body(exceptionResponse);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException exception,
			HttpServletRequest servletRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();

		exceptionResponse.setPath(servletRequest.getRequestURI());
		exceptionResponse.setError("Internal server error");
		exceptionResponse.setMessage(exception.getMessage());
		exceptionResponse.setStatus(500);
		exceptionResponse.setTimestamp(LocalDateTime.now());

		return ResponseEntity.badRequest().body(exceptionResponse);
	}
}
