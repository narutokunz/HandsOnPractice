# Cognizant — Week 2

Topics: Spring Core and Maven · Spring Data JPA with Spring Boot · Hibernate

## Structure
```
src/main/java/com/practice/
├── Application.java       # Spring Boot entry point
└── week2/
    ├── springcore/         # Spring IoC / Dependency Injection (GreetingService + GreetingRunner)
    ├── jpa/                # Spring Data JPA (Student entity + repository + runner)
    └── hibernate/           # Standalone Hibernate (no Spring) — Employee entity

src/main/resources/
├── application.properties  # H2 DB config for the Spring Boot app
└── hibernate.cfg.xml       # Config for the standalone Hibernate demo
```

## How to run

**Spring Core + Spring Data JPA:**
```
mvn spring-boot:run
```
Console output on startup shows the DI demo (`GreetingRunner`) and the JPA save/query demo (`StudentJpaRunner`).

Optional — browse the DB: `http://localhost:8080/h2-console` → JDBC URL `jdbc:h2:mem:testdb`

**Hibernate (standalone):**
Run `HibernateDemo.java` directly (it has its own `main()`, separate from the Spring
Boot app) — this shows what Spring Data JPA does under the hood without Spring
managing it for you.
