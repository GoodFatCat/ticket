package com.github.goodfatcat.ticketservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
	private Long id;
	private String name;
	private double price;
	private Long eventId;
	private TicketType type;
}
