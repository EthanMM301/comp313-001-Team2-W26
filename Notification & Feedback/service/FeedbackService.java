package com.team4.events.service;

import com.team4.events.model.Feedback;
import com.team4.events.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    public Feedback addFeedback(Feedback f) {
        return repo.save(f);
    }

    public List<Feedback> getByEvent(int eventId) {
        return repo.findByEventId(eventId);
    }

    public List<Feedback> getAll() {
        return repo.findAll();
    }
}
