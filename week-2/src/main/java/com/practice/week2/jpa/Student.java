package com.practice.week2.jpa;

import jakarta.persistence.*;

/**
 * SPRING DATA JPA — Entity mapped to a database table.
 * @Entity + @Id/@GeneratedValue tell JPA how to persist and generate keys.
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String course;

    protected Student() { } // required no-arg constructor for JPA

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', course='" + course + "'}";
    }
}
