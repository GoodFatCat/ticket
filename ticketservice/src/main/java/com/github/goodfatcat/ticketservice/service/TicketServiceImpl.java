package com.github.goodfatcat.ticketservice.service;

import org.springframework.stereotype.Service;

import com.github.goodfatcat.ticketservice.dto.TicketTypeRequest;
import com.github.goodfatcat.ticketservice.exception.NoSuchTicketTypeException;
import com.github.goodfatcat.ticketservice.model.TicketType;
import com.github.goodfatcat.ticketservice.repository.TicketTypeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketTypeRepository ticketTypeRepository; 

	@Override
	public TicketType createType(TicketTypeRequest request) {
		TicketType ticketType = TicketType.geTicketTypeByTicketTypeRequest(request);
		return ticketTypeRepository.save(ticketType);
	}

	@Override
	public TicketType getTicketTypeByStringType(String type) {
		return ticketTypeRepository.findByType(type).orElseThrow(() -> new NoSuchTicketTypeException(String.format("No such type %s", type)));
	}

	@Override
	public TicketType getTicketTypeById(Long id) {
		return ticketTypeRepository.findById(id).orElseThrow(() -> new NoSuchTicketTypeException(String.format("No such type %o", id)));
	}
}
