package com.github.goodfatcat.ticketservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private LocalDateTime timestamp;
	private int status;
	private String message;
	private String error;
	private String path;
}
