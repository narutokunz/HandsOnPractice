package com.practice.week2.hibernate;

import jakarta.persistence.*;

/**
 * HIBERNATE — this looks identical to a JPA entity because Hibernate IS the
 * default JPA implementation Spring Data JPA uses under the hood.
 * Here we use it standalone (no Spring) with a plain SessionFactory to see
 * what Spring Data JPA normally hides from you.
 */
@Entity
@Table(name = "employee_hibernate")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String designation;

    public Employee() { }

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', designation='" + designation + "'}";
    }
}
