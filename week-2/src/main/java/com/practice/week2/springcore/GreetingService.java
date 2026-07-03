package com.practice.week2.springcore;

import org.springframework.stereotype.Component;

/**
 * SPRING CORE — a plain Java class becomes a managed "bean" via @Component.
 * The Spring IoC container creates and owns its lifecycle.
 */
@Component
public class GreetingService {
    public String greet(String name) {
        return "Hello, " + name + "! This bean was created and injected by the Spring IoC container.";
    }
}
