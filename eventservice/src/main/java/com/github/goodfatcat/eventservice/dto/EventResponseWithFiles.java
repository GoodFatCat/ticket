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
public class EventResponseWithFiles {
	private Long id;
	private String name;
	private List<byte[]> filesList;
	private LocalDateTime eventDateTime;
	private String description;
	private Integer numberSeats;
	
	public EventResponseWithFiles(Event event, List<byte[]> filesList) {
		this.id = event.getId();
		this.name = event.getName();
		this.eventDateTime = event.getEventDateTime();
		this.description = event.getDescription();
		this.numberSeats = event.getNumberSeats();
		this.filesList = filesList;
	}
}

