package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for Week 2. Starts the Spring context and runs the
 * Spring Core (DI) and Spring Data JPA CommandLineRunner demos.
 *
 * Run with: mvn spring-boot:run
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
