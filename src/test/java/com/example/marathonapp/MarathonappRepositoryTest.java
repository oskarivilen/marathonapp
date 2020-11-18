package com.example.marathonapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;
import com.example.marathonapp.model.Starter;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MarathonappRepositoryTest {

   @Autowired
   private RunnerRepository repository;
   @Test
   public void findByTitleShouldReturnBook() {
       List<Runner> runners = repository.findByName("Oskari Vilen");
       
       assertThat(runners).hasSize(1);
       assertThat(runners.get(0).getTeam()).isEqualTo("Helsinki RC");
   }
   
   // Test if app can create new Runner
   @Test
   public void createNewRunner() {
   	Runner runner = new Runner(9, "Oskari Vilen", "Helsinki RC", new Starter("16:00"));
   	repository.save(runner);
   	assertThat(runner.getId()).isNotNull();
   }    
   
   // Test if app can delete Runner
   @Test
   public void deleteRunner() {
   	Runner runner = new Runner(9, "Oskari Vilen", "Helsinki RC", new Starter("16:00"));
   
		repository.delete(runner);
		assertThat(runner.getId()).isNotNull();
		
	}
}