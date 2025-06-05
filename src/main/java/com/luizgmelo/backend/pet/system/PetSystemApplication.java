package com.luizgmelo.backend.pet.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetSystemApplication.class, args);
	}

}
