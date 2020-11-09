package com.example.marathonapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.marathonapp.model.Runner;
import com.example.marathonapp.model.RunnerRepository;
import com.example.marathonapp.model.Starter;
import com.example.marathonapp.model.Starterrepository;


@SpringBootApplication
public class MarathonappApplication {

	private static final Logger log = LoggerFactory.getLogger(MarathonappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarathonappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runnerDemo(RunnerRepository rrepository, Starterrepository srepository) {
		return (args) -> {
			log.info("save a couple of runners");
			
			srepository.save(new Starter("12:00"));
			srepository.save(new Starter("13:00"));
			
			rrepository.save(new Runner(1, "Oskari Vilen", "Jets", srepository.findByStime("12:00").get(0)));
			rrepository.save(new Runner(2, "James Corey", "Foxes", srepository.findByStime("13:00").get(0)));
			
		
			log.info("fetch all runners");
			
			for (Runner runner : rrepository.findAll()) {
				log.info(runner.toString());
				
			}

		};
	}
}