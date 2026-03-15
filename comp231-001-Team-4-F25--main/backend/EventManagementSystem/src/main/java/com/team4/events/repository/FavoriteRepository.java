package com.team4.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.events.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    void deleteByUserIdAndEventId(int userId, int eventId);
}
