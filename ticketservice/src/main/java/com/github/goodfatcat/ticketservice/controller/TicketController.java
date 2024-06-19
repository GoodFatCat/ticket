package com.github.goodfatcat.ticketservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.goodfatcat.ticketservice.dto.TicketTypeRequest;
import com.github.goodfatcat.ticketservice.dto.TicketTypeResponse;
import com.github.goodfatcat.ticketservice.service.TicketService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {
	private TicketService ticketService;

	@PostMapping(path = "/type", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public TicketTypeResponse postMethodName(@RequestBody TicketTypeRequest request) {
		return TicketTypeResponse.getTicketTypeResponseByTicketType(ticketService.createType(request));
	}
	
	@GetMapping("/type/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TicketTypeResponse getMethodName(@PathVariable Long id) {
		return TicketTypeResponse.getTicketTypeResponseByTicketType(ticketService.getTicketTypeById(id));
	}
	
	@GetMapping("/type/{type}")
	public TicketTypeResponse getMethodName(@PathVariable String type) {
		return TicketTypeResponse.getTicketTypeResponseByTicketType(ticketService.getTicketTypeByStringType(type));
	}
	
}
