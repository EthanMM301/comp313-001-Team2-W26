package com.team4.events.service;

import com.team4.events.model.Notification;
import com.team4.events.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repo;

    public Notification create(Notification n) {
        return repo.save(n);
    }

    public List<Notification> getByUser(int userId) {
        return repo.findByUserId(userId);
    }

    public void markAsRead(int id) {
        Notification n = repo.findById(id).orElse(null);
        if (n != null) {
            n.setReadStatus(true);
            repo.save(n);
        }
    }
}