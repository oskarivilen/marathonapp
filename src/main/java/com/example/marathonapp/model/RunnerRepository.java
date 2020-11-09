package com.example.marathonapp.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner, Long> {

    List<Runner> findByName(String name);

	
    
}