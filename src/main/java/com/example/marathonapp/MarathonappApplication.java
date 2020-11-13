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
import com.example.marathonapp.model.User;
import com.example.marathonapp.model.UserRepository;


@SpringBootApplication
public class MarathonappApplication {

	private static final Logger log = LoggerFactory.getLogger(MarathonappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarathonappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runnerDemo(RunnerRepository rrepository, Starterrepository srepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of runners");
			
			srepository.save(new Starter("12:00"));
			srepository.save(new Starter("12:30"));
			srepository.save(new Starter("13:00"));
			srepository.save(new Starter("13:30"));
			srepository.save(new Starter("14:00"));
			
			rrepository.save(new Runner(1, "Oskari Vilen", "Helsinki RC", srepository.findByStime("12:30").get(0)));
			rrepository.save(new Runner(2, "James Corey", "Star-runner", srepository.findByStime("12:00").get(0)));
			rrepository.save(new Runner(2, "Dean Winchester", "Hunters", srepository.findByStime("13:30").get(0)));
			rrepository.save(new Runner(2, "Urho Kekkonen", "Helsinki RC", srepository.findByStime("14:00").get(0)));
			rrepository.save(new Runner(2, "Gandalf White", "The Fellowship", srepository.findByStime("12:00").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
 			User user2 = new User("oskari", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
 			User user3 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
 			urepository.save(user1);
 			urepository.save(user2);
 			urepository.save(user3);
		
			log.info("fetch all runners");
			
			for (Runner runner : rrepository.findAll()) {
				log.info(runner.toString());
				
			}

		};
	}
}