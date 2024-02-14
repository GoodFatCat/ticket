package com.github.goodfatcat.seattickettypeservice.service;

import java.util.List;

import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeRequest;
import com.github.goodfatcat.seattickettypeservice.model.TicketType;

public interface TicketTypeService {
	TicketType getTicketTypeById(Long id);
	List<TicketType> getAllSeatTicketTypes();
	TicketType createTicketType(TicketTypeRequest request);
	TicketType getTicketTypeByType(TicketTypeRequest type);
}
