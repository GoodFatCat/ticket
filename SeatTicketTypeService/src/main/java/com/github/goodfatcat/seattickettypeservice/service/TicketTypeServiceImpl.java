package com.github.goodfatcat.seattickettypeservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeRequest;
import com.github.goodfatcat.seattickettypeservice.exception.NoSuchTypeException;
import com.github.goodfatcat.seattickettypeservice.exception.NoTypesException;
import com.github.goodfatcat.seattickettypeservice.model.TicketType;
import com.github.goodfatcat.seattickettypeservice.repository.TicketTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {
	private TicketTypeRepository repository;

	@Override
	public TicketType getTicketTypeById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NoSuchTypeException(
						String.format("No such type with id=%d", id)));
	}

	@Override
	public List<TicketType> getAllSeatTicketTypes() {
		List<TicketType> allTypes = repository.findAll();
		if (allTypes.size() < 0) {
			throw new NoTypesException("Db doesn't have any type");
		}
		return allTypes;
	}

	@Override
	public TicketType createTicketType(TicketTypeRequest request) {
		return repository.save(new TicketType(request));
	}

	@Override
	public TicketType getTicketTypeByType(TicketTypeRequest request) {
		return repository.findByType(request.getType())
				.orElseThrow(() -> new NoSuchTypeException(
						String.format("No such type %s", request.getType())));
	}

}
