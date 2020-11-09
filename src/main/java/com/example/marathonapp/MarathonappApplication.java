package com.example.marathonapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//import com.example.marathonapp.model.Group;
//import com.example.marathonapp.model.GroupRepository;
import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;


@SpringBootApplication
public class MarathonappApplication {

	private static final Logger log = LoggerFactory.getLogger(MarathonappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarathonappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runnerDemo(RunnerRepository rrepository) {
		return (args) -> {
			log.info("save a couple of runners");
			
		
		
			
			rrepository.save(new Runner(1, "Oskari Vilen", "Jets"));
			rrepository.save(new Runner(2, "James Corey", "Foxes"));
			
		
			log.info("fetch all runners");
			
			for (Runner runner : rrepository.findAll()) {
				log.info(runner.toString());
				
			}

		};
	}
}