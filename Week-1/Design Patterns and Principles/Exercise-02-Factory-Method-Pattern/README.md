# Exercise 2: Factory Method Pattern

## Problem Statement
Create Word, PDF, and Excel documents through a document management factory hierarchy.

## Approach
Abstract DocumentFactory with concrete factories implementing createDocument(); follows Open/Closed Principle.

## How to Run
cd "Week-1/Design Patterns and Principles/Exercise-02-Factory-Method-Pattern"
javac -d out src/com/cognizant/javadfse/week1/designpatterns/factory/*.java
java -cp out com.cognizant.javadfse.week1.designpatterns.factory.FactoryMethodPatternExample

## Expected Output
```
Document creation messages for Word, PDF, and Excel factories.
```
