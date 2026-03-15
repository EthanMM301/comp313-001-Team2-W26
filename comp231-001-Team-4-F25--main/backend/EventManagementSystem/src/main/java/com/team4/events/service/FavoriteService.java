package com.team4.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.events.model.Favorite;
import com.team4.events.repository.FavoriteRepository;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository repo;

    public Favorite addFavorite(Favorite fav) {
        return repo.save(fav);
    }

    public void removeFavorite(int userId, int eventId) {
        repo.deleteByUserIdAndEventId(userId, eventId);
    }
}
