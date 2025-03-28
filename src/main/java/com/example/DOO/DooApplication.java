package com.example.DOO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.DOO.repo")
public class DooApplication {

	public static void main(String[] args) {
		SpringApplication.run(DooApplication.class, args);
	}

}
