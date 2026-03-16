package com.team4.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.events.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
