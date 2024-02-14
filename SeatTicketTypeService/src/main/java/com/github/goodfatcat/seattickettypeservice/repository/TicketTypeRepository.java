package com.github.goodfatcat.seattickettypeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.goodfatcat.seattickettypeservice.model.TicketType;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long>{
	Optional<TicketType> findByType(String type);
}
