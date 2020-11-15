package com.example.marathonapp.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Extends CrudRepository to UserRepository with a List of users


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
} 