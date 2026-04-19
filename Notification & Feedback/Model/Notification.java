package com.team4.events.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int eventId;
    private String message;
    private Date createdAt = new Date();
    private boolean readStatus = false;

    // GETTERS
    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getEventId() { return eventId; }
    public String getMessage() { return message; }
    public Date getCreatedAt() { return createdAt; }
    public boolean isReadStatus() { return readStatus; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setEventId(int eventId) { this.eventId = eventId; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public void setReadStatus(boolean readStatus) { this.readStatus = readStatus; }
}