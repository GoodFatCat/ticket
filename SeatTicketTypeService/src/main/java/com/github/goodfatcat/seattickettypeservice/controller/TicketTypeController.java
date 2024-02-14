package com.github.goodfatcat.seattickettypeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeRequest;
import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeResponse;
import com.github.goodfatcat.seattickettypeservice.service.TicketTypeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket/type")
public class TicketTypeController {
	private TicketTypeService ticketTypeService;

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TicketTypeResponse getTypeById(@PathVariable Long id) {
		return TicketTypeResponse.getResponseByTicketType(
				ticketTypeService.getTicketTypeById(id));
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public TicketTypeResponse getTypeByType(TicketTypeRequest request) {
		return TicketTypeResponse.getResponseByTicketType(ticketTypeService.getTicketTypeByType(request));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public TicketTypeResponse createTicketType(@RequestBody TicketTypeRequest request) {
		return TicketTypeResponse.getResponseByTicketType(ticketTypeService.createTicketType(request));
	}
}
