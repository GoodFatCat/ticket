package com.github.goodfatcat.seattickettypeservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeRequest;
import com.github.goodfatcat.seattickettypeservice.exception.NoSuchTypeException;
import com.github.goodfatcat.seattickettypeservice.model.TicketType;
import com.github.goodfatcat.seattickettypeservice.repository.TicketTypeRepository;

class TicketTypeServiceImplTest {
	private TicketTypeRepository repository = Mockito
			.mock(TicketTypeRepository.class);
	private TicketTypeService obj = new TicketTypeServiceImpl(
			repository);

	@Test
	void shouldProperlyGetById() {
		Long id = 1L;

		TicketType expected = new TicketType(1L, "Test type");

		Mockito.when(repository.findById(id)).thenReturn(Optional.of(expected));

		TicketType actual = obj.getTicketTypeById(id);

		assertEquals(expected, actual);
		Mockito.verify(repository).findById(id);
	}

	@Test
	void shouldThrowNoSuchTypeExceptionById() {
		Long id = 2L;

		Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

		assertThrows(NoSuchTypeException.class,
				() -> obj.getTicketTypeById(id));
	}

	@Test
	void shouldProperlyGetByType() {
		String type = "My type";
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(type);

		TicketType expected = new TicketType(1L, type);

		Mockito.when(repository.findByType(type))
				.thenReturn(Optional.of(expected));

		TicketType actual = obj.getTicketTypeByType(ticketTypeRequest);

		assertEquals(expected, actual);
		Mockito.verify(repository).findByType(type);
	}

	@Test
	void shouldThrowNoSuchTypeExceptionByType() {
		String type = "No type";
		TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(type);

		Mockito.when(repository.findByType(type)).thenReturn(Optional.empty());

		assertThrows(NoSuchTypeException.class,
				() -> obj.getTicketTypeByType(ticketTypeRequest));
		
		Mockito.verify(repository).findByType(type);
	}
	
	@Test
	void shouldProperlySaveNewTypeTicket() {
		String type = "New type";
		
		TicketTypeRequest seatTicketTypeRequest = new TicketTypeRequest(type);
		
		TicketType expected = new TicketType(seatTicketTypeRequest);
		
		Mockito.when(repository.save(expected)).thenReturn(expected);
		
		TicketType actual = obj.createTicketType(seatTicketTypeRequest);
		
		assertEquals(expected, actual);
		
		Mockito.verify(repository).save(expected);
	}
}
