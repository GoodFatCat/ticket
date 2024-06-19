package com.github.goodfatcat.ticketservice.service;

import com.github.goodfatcat.ticketservice.dto.TicketTypeRequest;
import com.github.goodfatcat.ticketservice.model.TicketType;

public interface TicketService {
	TicketType createType(TicketTypeRequest request);
	TicketType getTicketTypeByStringType(String type);
	TicketType getTicketTypeById(Long id);
}
