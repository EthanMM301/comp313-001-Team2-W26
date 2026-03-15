package com.team4.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.events.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
