package com.github.goodfatcat.eventservice.model;

import java.time.LocalDateTime;
import java.util.List;

import com.github.goodfatcat.eventservice.dto.EventRequest;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ElementCollection
	@CollectionTable(name = "event_files")
	@Column(name = "file_name")
	private List<String> fileNames;
	private LocalDateTime eventDateTime;
	private String description;
	
	public Event(EventRequest request, List<String> fileNames) {
		this.name = request.getName();
		this.eventDateTime = request.getEventDateTime();
		this.description = request.getDescription();
		this.fileNames = fileNames;
	}
}
