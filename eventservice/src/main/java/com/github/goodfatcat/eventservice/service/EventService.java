package com.github.goodfatcat.eventservice.service;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;
import com.github.goodfatcat.eventservice.dto.EventResponseWithFiles;

public interface EventService {
	EventResponse saveEvent(EventRequest request);
	public EventResponseWithFiles getEvent(Long id);
}
