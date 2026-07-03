package com.practice.week2.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * HIBERNATE (raw, no Spring) — building a SessionFactory manually and
 * running a save + query inside an explicit transaction.
 * Config lives in src/main/resources/hibernate.cfg.xml
 *
 * Run this class directly (it has its own main), NOT via spring-boot:run.
 */
public class HibernateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(new Employee("Ananya", "Software Engineer"));
            session.persist(new Employee("Vikram", "QA Engineer"));

            tx.commit();

            Employee found = session.createQuery(
                    "from Employee where designation = :d", Employee.class)
                    .setParameter("d", "Software Engineer")
                    .uniqueResult();

            System.out.println("[Week2-Hibernate] Found: " + found);
        } finally {
            sessionFactory.close();
        }
    }
}
