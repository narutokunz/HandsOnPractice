# Exercise 1: Singleton Pattern

## Problem Statement
Ensure a logging utility has only one instance across the application lifecycle.

## Approach
Double-checked locking Singleton with private constructor and static getInstance(); thread-safe via synchronized block. O(1) access.

## How to Run
cd "Week-1/Design Patterns and Principles/Exercise-01-Singleton-Pattern"
javac -d out src/com/cognizant/javadfse/week1/designpatterns/singleton/*.java
java -cp out com.cognizant.javadfse.week1.designpatterns.singleton.SingletonPatternExample

## Expected Output
```
Same Logger instance reference printed twice; log messages with timestamps.
```
