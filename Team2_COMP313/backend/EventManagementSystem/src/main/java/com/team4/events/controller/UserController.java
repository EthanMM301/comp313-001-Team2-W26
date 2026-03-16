package com.team4.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.events.model.User;
import com.team4.events.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/register")
    public User createUser(@RequestBody User u) {
        return repo.save(u);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
