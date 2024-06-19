package com.github.goodfatcat.ticketservice.dto;

import com.github.goodfatcat.ticketservice.model.TicketType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeResponse {
	private Long id;
	private String type;
	
	public static TicketTypeResponse getTicketTypeResponseByTicketType(TicketType ticketType) {
		return new TicketTypeResponse(ticketType);
	}
	
	private TicketTypeResponse(TicketType ticketType) {
		this.id = ticketType.getId();
		this.type = ticketType.getType();
	}
}
