package com.team4.events.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.team4.events.model.Rsvp;

public interface RsvpRepository extends JpaRepository<Rsvp, Integer> {
    List<Rsvp> findByUserId(int userId);
    boolean existsByUserIdAndEventId(int userId, int eventId);
    void deleteByUserIdAndEventId(int userId, int eventId);
}