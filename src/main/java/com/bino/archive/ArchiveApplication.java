package com.bino.archive;

import com.bino.archive.model.Armoire;
import com.bino.archive.model.Ranger;
import com.bino.archive.repository.ArmoireRepository;
import com.bino.archive.repository.ClasseurRepository;
import com.bino.archive.repository.DocumentRepository;
import com.bino.archive.repository.RangerRepository;
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
	CommandLineRunner runner(ArmoireRepository armoireRepository, RangerRepository rangerRepository, ClasseurRepository classeurRepository, DocumentRepository documentRepository){
		return args -> {
			Armoire a1 = armoireRepository.save(new Armoire(null,"Armoire 1", "armoire_1", LocalDateTime.now(),LocalDateTime.now(),"Jaune"));
			Armoire a2 = armoireRepository.save(new Armoire(null,"Armoire 2", "armoire_2",LocalDateTime.now(),LocalDateTime.now(),"Vert"));
			Armoire a3 = armoireRepository.save(new Armoire(null,"Armoire 3", "armoire_3",LocalDateTime.now(),LocalDateTime.now(),"Rouge"));
			Armoire a4 = armoireRepository.save(new Armoire(null,"Armoire 4", "armoire_4",LocalDateTime.now(),LocalDateTime.now(),"Noir"));

			rangerRepository.save(new Ranger(null, "Ranger 1", "ranger_1"+a1.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a1));
			rangerRepository.save(new Ranger(null, "Ranger 2", "ranger_2"+a1.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a1));

			rangerRepository.save(new Ranger(null, "Ranger 1", "ranger_1"+a2.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a2));
			rangerRepository.save(new Ranger(null, "Ranger 2", "ranger_2"+a2.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a2));

			rangerRepository.save(new Ranger(null, "Ranger 1", "ranger_1"+a3.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a3));
			rangerRepository.save(new Ranger(null, "Ranger 2", "ranger_2"+a3.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a3));

			rangerRepository.save(new Ranger(null, "Ranger 1", "ranger_1"+a4.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a4));
			rangerRepository.save(new Ranger(null, "Ranger 2", "ranger_2"+a4.getSlug(), LocalDateTime.now(), LocalDateTime.now(), a4));

//			classeurRepository.save();
//			classeurRepository.save();
//			classeurRepository.save();
//			classeurRepository.save();
//
//			documentRepository.save();
//			documentRepository.save();
//			documentRepository.save();
//			documentRepository.save();
		};
	}
}
