package com.example.marathonapp.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Extends CrudRepository to Starterrepository with a List of starting times


public interface Starterrepository extends CrudRepository<Starter, Long> {

    List<Starter> findByStime(String stime);
    
}