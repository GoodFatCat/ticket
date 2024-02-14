package com.github.goodfatcat.seattickettypeservice.model;

import com.github.goodfatcat.seattickettypeservice.dto.TicketTypeRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	
	public TicketType(TicketTypeRequest request) {
		this.type = request.getType(); 
	}
}
