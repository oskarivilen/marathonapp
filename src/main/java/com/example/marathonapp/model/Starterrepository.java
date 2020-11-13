package com.example.marathonapp.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Starterrepository extends CrudRepository<Starter, Long> {

    List<Starter> findByStime(String stime);
    
}