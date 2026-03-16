package com.team4.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.events.model.Event;
import com.team4.events.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event getEventById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Event updateEvent(int id, Event event) {
        Event old = repo.findById(id).orElse(null);

        if (old == null) return null;

        old.setTitle(event.getTitle());
        old.setDescription(event.getDescription());
        old.setDate(event.getDate());
        old.setLocation(event.getLocation());
        old.setCategory(event.getCategory());

        return repo.save(old);
    }

    public void deleteEvent(int id) {
        repo.deleteById(id);
    }
}
