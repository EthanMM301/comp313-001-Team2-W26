package com.team4.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team4.events.model.User;
import com.team4.events.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User updateUser(int id, User newData) {
        User u = repo.findById(id).orElse(null);

        if (u == null) return null;

        u.setName(newData.getName());
        u.setEmail(newData.getEmail());
        u.setPhone(newData.getPhone());

        return repo.save(u);
    }
}

