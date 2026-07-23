# Spring Core Exercises 1, 2, and 4

## Problem Statement
Configure Spring IoC container with Maven, XML beans, and setter injection for library management.

## Approach
ClassPathXmlApplicationContext loads applicationContext.xml; BookService receives BookRepository via setter injection.

## How to Run
cd "Week-2/Spring Core and Maven/LibraryManagement"
mvn compile exec:java

## Expected Output
```
Starting Spring IoC Container...
BookService invoked via setter injection.
Retrieved book: Clean Code by Robert C. Martin
```
