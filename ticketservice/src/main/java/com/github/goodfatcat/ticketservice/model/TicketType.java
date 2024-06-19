package com.github.goodfatcat.ticketservice.model;

import com.github.goodfatcat.ticketservice.dto.TicketTypeRequest;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TicketType {
	private Long id;
	private String type;
	
	public static TicketType geTicketTypeByTicketTypeRequest(TicketTypeRequest request) {
		return new TicketType(request);
	}
	
	private TicketType(TicketTypeRequest request) {
		this.type = request.getType();
	}
}
