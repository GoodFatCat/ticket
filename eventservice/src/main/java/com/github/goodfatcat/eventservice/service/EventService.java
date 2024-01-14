package com.github.goodfatcat.eventservice.service;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;

public interface EventService {
	EventResponse saveEvent(EventRequest request);
}
