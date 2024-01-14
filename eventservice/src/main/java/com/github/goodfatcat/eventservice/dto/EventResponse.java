package com.github.goodfatcat.eventservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.github.goodfatcat.eventservice.model.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
	private Long id;
	private String name;
	private List<String> fileNames;
	private LocalDateTime eventDateTime;
	private String description;
	
	public EventResponse(Event event) {
		this.id = event.getId();
		this.name = event.getName();
		this.fileNames = event.getFileNames();
		this.eventDateTime = event.getEventDateTime();
		this.description = event.getDescription();
	}
}
