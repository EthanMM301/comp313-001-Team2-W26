package com.team4.events.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.team4.events.model.Rsvp;
import com.team4.events.repository.RsvpRepository;
import com.team4.events.model.Notification;
import com.team4.events.service.NotificationService;

@RestController
@RequestMapping("/api/rsvp")
public class RsvpController {

    @Autowired
    private RsvpRepository repo;

    @Autowired
    private NotificationService notificationService;

    // RSVP to an event
    @PostMapping("/add")
    public Rsvp addRsvp(@RequestBody Rsvp rsvp) {

    // Save RSVP
    Rsvp saved = repo.save(rsvp);

    // Create notification
    Notification n = new Notification();
    n.setUserId(rsvp.getUserId());
    n.setEventId(rsvp.getEventId());
    n.setMessage("You have successfully RSVP’d to an event 🎉");

    notificationService.create(n);

    return saved;
}

    // Cancel RSVP
    @Transactional
    @DeleteMapping("/remove")
    public String removeRsvp(@RequestParam int userId, @RequestParam int eventId) {

    repo.deleteByUserIdAndEventId(userId, eventId);

    // Optional notification
    Notification n = new Notification();
    n.setUserId(userId);
    n.setEventId(eventId);
    n.setMessage("Your RSVP has been cancelled.");

    notificationService.create(n);

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
