package com.github.goodfatcat.eventservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;
import com.github.goodfatcat.eventservice.service.EventService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/event")
@AllArgsConstructor
public class EventController {
	private EventService eventService;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public EventResponse createEvent(@ModelAttribute EventRequest request) {
		return eventService.saveEvent(request);
	}
}
