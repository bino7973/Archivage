package com.bino.archive;

import com.bino.archive.model.Armoire;
import com.bino.archive.repository.ArmoireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ArchiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchiveApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ArmoireRepository armoireRepository){
		return args -> {
			armoireRepository.save(new Armoire(null,"Armoire 1", "armoire_1", LocalDateTime.now(),LocalDateTime.now(),"Jaune"));
			armoireRepository.save(new Armoire(null,"Armoire 2", "armoire_2",LocalDateTime.now(),LocalDateTime.now(),"Vert"));
			armoireRepository.save(new Armoire(null,"Armoire 3", "armoire_3",LocalDateTime.now(),LocalDateTime.now(),"Rouge"));
			armoireRepository.save(new Armoire(null,"Armoire 4", "armoire_4",LocalDateTime.now(),LocalDateTime.now(),"Noir"));
		};
	}
}
