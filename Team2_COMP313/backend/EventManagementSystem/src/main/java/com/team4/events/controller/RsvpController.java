package com.team4.events.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.team4.events.model.Rsvp;
import com.team4.events.repository.RsvpRepository;

@RestController
@RequestMapping("/api/rsvp")
public class RsvpController {

    @Autowired
    private RsvpRepository repo;

    // RSVP to an event
    @PostMapping("/add")
    public Rsvp addRsvp(@RequestBody Rsvp rsvp) {
        return repo.save(rsvp);
    }

    // Cancel RSVP
    @Transactional
    @DeleteMapping("/remove")
    public String removeRsvp(@RequestParam int userId, @RequestParam int eventId) {
        repo.deleteByUserIdAndEventId(userId, eventId);
        return "RSVP cancelled";
    }

    // Check if user has RSVP'd
    @GetMapping("/check")
    public boolean checkRsvp(@RequestParam int userId, @RequestParam int eventId) {
        return repo.existsByUserIdAndEventId(userId, eventId);
    }

    // Get all RSVPs for a user
    @GetMapping("/user/{userId}")
    public List<Rsvp> getUserRsvps(@PathVariable int userId) {
        return repo.findByUserId(userId);
    }
}