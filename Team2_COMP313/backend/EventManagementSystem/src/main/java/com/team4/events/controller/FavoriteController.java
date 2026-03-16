package com.team4.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.events.model.Favorite;
import com.team4.events.service.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService service;

    @PostMapping("/add")
    public Favorite add(@RequestBody Favorite f) {
        return service.addFavorite(f);
    }

    @PostMapping("/remove")
    public String remove(@RequestBody Favorite f) {
        service.removeFavorite(f.getUserId(), f.getEventId());
        return "Removed from favorites";
    }
}
