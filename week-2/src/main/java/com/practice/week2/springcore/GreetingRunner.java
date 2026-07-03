package com.practice.week2.springcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * SPRING CORE — DEPENDENCY INJECTION
 * GreetingService is injected via the constructor instead of being created
 * manually with "new" — this is the core idea behind Spring Core / IoC.
 * CommandLineRunner beans run automatically once the app context starts.
 */
@Component
@Order(1)
public class GreetingRunner implements CommandLineRunner {

    private final GreetingService greetingService; // injected dependency

    public GreetingRunner(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void run(String... args) {
        System.out.println("[Week2-SpringCore] " + greetingService.greet("Niharika"));
    }
}
