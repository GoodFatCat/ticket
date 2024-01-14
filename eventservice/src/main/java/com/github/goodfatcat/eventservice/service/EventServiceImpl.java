package com.github.goodfatcat.eventservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;
import com.github.goodfatcat.eventservice.model.Event;
import com.github.goodfatcat.eventservice.repository.EventRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

	private StorageService storageService;
	private EventRepository eventRepository;

	@Override
	public EventResponse saveEvent(EventRequest request) {
		LocalDateTime eventDateTime = request.getEventDateTime();
		
		String fileNamePrefix = String.format("%s-%d-%d-%d-", request.getName(),
				eventDateTime.getYear(), eventDateTime.getMonth().getValue(),
				eventDateTime.getDayOfMonth());
		
		List<String> fileNames = storageService.saveFiles(fileNamePrefix,
				request.getFiles());

		Event eventToSave = new Event(request, fileNames);

		Event savedEvent = eventRepository.save(eventToSave);

		return new EventResponse(savedEvent);
	}

}
