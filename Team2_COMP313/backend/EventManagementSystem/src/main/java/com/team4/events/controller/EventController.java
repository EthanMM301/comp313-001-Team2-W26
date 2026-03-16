package com.team4.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.events.model.Event;
import com.team4.events.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event e) {
        return service.createEvent(e);
    }

    @GetMapping("/all")
    public List<Event> getAll() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable int id) {
        return service.getEventById(id);
    }

    @PutMapping("/update/{id}")
    public Event update(@PathVariable int id, @RequestBody Event e) {
        return service.updateEvent(id, e);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteEvent(id);
        return "Event deleted";
    }
}
