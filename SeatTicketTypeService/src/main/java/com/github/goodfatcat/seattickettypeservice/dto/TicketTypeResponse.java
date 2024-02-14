package com.github.goodfatcat.seattickettypeservice.dto;

import com.github.goodfatcat.seattickettypeservice.model.TicketType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeResponse {
	private Long id;
	private String type;
	
	private TicketTypeResponse(TicketType seatTicketType) {
		this.id = seatTicketType.getId();
		this.type = seatTicketType.getType();
	}
	
	public static TicketTypeResponse getResponseByTicketType(TicketType seatTicketType) {
		return new TicketTypeResponse(seatTicketType);
	}
}
