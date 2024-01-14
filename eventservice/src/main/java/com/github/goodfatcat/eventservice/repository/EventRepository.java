package com.github.goodfatcat.eventservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.goodfatcat.eventservice.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
