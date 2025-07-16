package com.github.goodfatcat.eventservice.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;
import com.github.goodfatcat.eventservice.dto.EventResponseWithFiles;
import com.github.goodfatcat.eventservice.exception.NoSuchEventException;
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
	
	public EventResponseWithFiles getEvent(Long id){
		Optional<Event> foundEvent = eventRepository.findById(id);
		
		if (foundEvent.isEmpty()) {
			throw new NoSuchEventException(String.format("No such event with id=%s", id));
		}
		
		Event event = foundEvent.get();
		List<byte[]> filesList = event.getFileNames().stream().map(x -> {
			try {
				return storageService.getFileByName(x);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
		
		return new EventResponseWithFiles(event, filesList);
	}

}
