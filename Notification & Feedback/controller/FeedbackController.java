package com.team4.events.controller;

import com.team4.events.model.Feedback;
import com.team4.events.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping("/add")
    public Feedback add(@RequestBody Feedback f) {
        return service.addFeedback(f);
    }

    @GetMapping("/event/{eventId}")
    public List<Feedback> getByEvent(@PathVariable int eventId) {
        return service.getByEvent(eventId);
    }

    @GetMapping("/all")
    public List<Feedback> getAll() {
        return service.getAll();
    }
}
