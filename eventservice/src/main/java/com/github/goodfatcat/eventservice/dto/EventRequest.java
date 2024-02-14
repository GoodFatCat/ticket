package com.github.goodfatcat.eventservice.dto;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
	private String name;
	private LocalDateTime eventDateTime;
	private String description;
	private Integer numberSeats;
	private MultipartFile[] files;
}
