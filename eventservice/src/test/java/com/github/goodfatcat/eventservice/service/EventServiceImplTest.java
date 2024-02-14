package com.github.goodfatcat.eventservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import com.github.goodfatcat.eventservice.dto.EventRequest;
import com.github.goodfatcat.eventservice.dto.EventResponse;
import com.github.goodfatcat.eventservice.model.Event;
import com.github.goodfatcat.eventservice.repository.EventRepository;

class EventServiceImplTest {
	
	private InFileSystemStorageService storageService = mock(InFileSystemStorageService.class);
	private EventRepository repository = mock(EventRepository.class);
	private EventServiceImpl eventService = new EventServiceImpl(storageService, repository);

	@Test
	void shouldProperlySaveRequest() {
		MultipartFile mockMultipartFile = Mockito.mock(MultipartFile.class);
		Mockito.when(mockMultipartFile.getOriginalFilename()).thenReturn("file.jpg");
		
		LocalDateTime now = LocalDateTime.now();
		
		EventRequest request = new EventRequest("Name", now, "Description", 15, new MultipartFile[] {mockMultipartFile});
		
		String fileNamePrefix = String.format("%s-%d-%d-%d-", request.getName(),
				now.getYear(), now.getMonth().getValue(),
				now.getDayOfMonth());
		
		String fileNames = fileNamePrefix + mockMultipartFile.getOriginalFilename();
		
		Event eventToSave = new Event(request, List.of(fileNames));
		
		Mockito.when(storageService.saveFiles(fileNamePrefix, request.getFiles())).thenReturn(List.of(fileNames));
		
		Event savedEvent = new Event(1L, "Name", List.of(mockMultipartFile.getOriginalFilename()), now, "Description", 15);
		
		Mockito.when(repository.save(eventToSave)).thenReturn(savedEvent);
		
		assertEquals(new EventResponse(savedEvent), eventService.saveEvent(request));
		
		Mockito.verify(repository).save(eventToSave);
		Mockito.verify(storageService).saveFiles(fileNamePrefix, new MultipartFile[] {mockMultipartFile});
	}

}
