package com.practice.week2.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demonstrates basic CRUD via Spring Data JPA against the H2 in-memory DB
 * configured in application.properties.
 */
@Component
@Order(2)
public class StudentJpaRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public StudentJpaRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        studentRepository.save(new Student("Niharika", "B.Tech CSE"));
        studentRepository.save(new Student("Rahul", "B.Tech ECE"));
        studentRepository.save(new Student("Priya", "B.Tech CSE"));

        System.out.println("[Week2-JPA] All students: " + studentRepository.findAll());

        List<Student> cseStudents = studentRepository.findByCourse("B.Tech CSE");
        System.out.println("[Week2-JPA] CSE students: " + cseStudents);
    }
}
