package com.example.marathonapp.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {

    List<Group> findByStime(String stime);
    
}