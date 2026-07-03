package com.practice.week2.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * SPRING DATA JPA — extending JpaRepository gives us save(), findAll(), findById(),
 * deleteById() etc. for free, with zero implementation code.
 * Derived query methods (like below) are auto-implemented from the method name.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(String course);
}
