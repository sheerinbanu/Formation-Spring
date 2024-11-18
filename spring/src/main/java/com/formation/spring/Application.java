package com.formation.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.formation.spring.entities.Book;
import com.formation.spring.repositories.BookRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("SpringBoot started successfully !!");
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return(args) -> {
			// repository.save(new Book("Livre 1", "Auteur 1", 10));	
		};
	}

}
