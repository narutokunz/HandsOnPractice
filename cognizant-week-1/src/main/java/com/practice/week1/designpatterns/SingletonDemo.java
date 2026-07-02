package com.practice.week1.designpatterns;

/**
 * SINGLETON PATTERN
 * Ensures a class has only one instance and provides a global point of access to it.
 * Thread-safe lazy initialization using double-checked locking.
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance;
    private int connectionCount = 0;

    private SingletonDemo() {
        System.out.println("SingletonDemo instance created");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public void connect() {
        connectionCount++;
        System.out.println("Connection #" + connectionCount);
    }

    public static void main(String[] args) {
        SingletonDemo a = SingletonDemo.getInstance();
        SingletonDemo b = SingletonDemo.getInstance();
        a.connect();
        b.connect();
        System.out.println("Same instance? " + (a == b));
    }
}
