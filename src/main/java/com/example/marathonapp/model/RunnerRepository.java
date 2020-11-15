package com.example.marathonapp.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Extends CrudRepository to RunnerRepository with a List of Runners

public interface RunnerRepository extends CrudRepository<Runner, Long> {

    List<Runner> findByName(String name);

	
    
}