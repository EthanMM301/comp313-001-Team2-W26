package com.team4.events.controller;

import com.team4.events.model.Notification;
import com.team4.events.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/create")
    public Notification create(@RequestBody Notification n) {
        return service.create(n);
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable int userId) {
        return service.getByUser(userId);
    }

    @PutMapping("/read/{id}")
    public String markRead(@PathVariable int id) {
        service.markAsRead(id);
        return "Marked as read";
    }
}