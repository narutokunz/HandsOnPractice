#  Week 1

Topics: Design Patterns · Data Structures & Algorithms · Advanced SQL · JUnit 5 + Mockito

## Structure
```
src/main/java/com/practice/week1/
├── designpatterns/   # Singleton, Factory, Observer, Strategy
├── dsa/               # Linked List, Binary Search, QuickSort, BST
└── testing/           # Calculator, PaymentService (classes under test)

src/test/java/com/practice/week1/testing/   # JUnit 5 + Mockito tests
sql/advanced_sql_practice.sql               # Joins, subqueries, CTEs, window functions, indexes, views
```

## How to run

**Design patterns / DSA:**
Each class has its own `main()` — run directly in your IDE, e.g. `SingletonDemo.java`, `BSTDemo.java`.

**Tests:**
```
mvn test
```

**SQL:**
Run `sql/advanced_sql_practice.sql` against MySQL/PostgreSQL, or any SQL client that supports CTEs and window functions.

## Note on "NUnit and Moq"
NUnit/Moq are .NET (C#) tools. Since this track is Java, this repo uses their direct
Java equivalents: **JUnit 5** (test framework, like NUnit) and **Mockito** (mocking
framework, like Moq).
