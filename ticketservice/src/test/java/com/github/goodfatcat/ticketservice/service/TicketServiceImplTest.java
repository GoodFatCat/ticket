package com.github.goodfatcat.ticketservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.github.goodfatcat.ticketservice.dto.TicketTypeRequest;
import com.github.goodfatcat.ticketservice.exception.NoSuchTicketTypeException;
import com.github.goodfatcat.ticketservice.model.TicketType;
import com.github.goodfatcat.ticketservice.repository.TicketTypeRepository;

class TicketServiceImplTest {

	private TicketTypeRepository repository = mock(TicketTypeRepository.class);
	private TicketService ticketService = new TicketServiceImpl(repository);

	@Test
	void shouldProperlyCreateType() {
		TicketTypeRequest request = new TicketTypeRequest("my new type");

		TicketType expected = TicketType
				.geTicketTypeByTicketTypeRequest(request);

		when(repository.save(expected)).thenReturn(expected);

		TicketType actual = ticketService.createType(request);

		assertEquals(expected, actual);
	}

	@Test
	void shouldProperlyGetTicketTypeByStringType() {
		String stringType = "my test get by type";

		Optional<TicketType> shouldReturnRepositoryFindByType = Optional
				.of(new TicketType(1L, stringType));

		when(repository.findByType(stringType))
				.thenReturn(shouldReturnRepositoryFindByType);

		TicketType expected = shouldReturnRepositoryFindByType.get();

		TicketType actual = ticketService.getTicketTypeByStringType(stringType);

		assertEquals(expected, actual);
	}

	@Test
	void shouldThrowNoSuchTicketTypeException() {
		String stringType = "should throw exception";

		when(repository.findByType(stringType)).thenReturn(Optional.empty());

		assertThrows(NoSuchTicketTypeException.class,
				() -> ticketService.getTicketTypeByStringType(stringType));
	}

	@Test
	void shouldProperlyGetById() {
		Long id = 2L;
		String stringType = "Type by id";
		
		when(repository.findById(id)).thenReturn(Optional.of(new TicketType(id, stringType)));
		
		TicketType expected = new TicketType(id,stringType );
		
		TicketType actual = ticketService.getTicketTypeById(id);
		
		assertEquals(expected, actual);
	}

}
