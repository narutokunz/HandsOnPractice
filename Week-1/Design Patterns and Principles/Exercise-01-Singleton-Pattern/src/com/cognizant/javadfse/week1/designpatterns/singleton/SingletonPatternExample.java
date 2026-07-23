package com.cognizant.javadfse.week1.designpatterns.singleton;

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Pehli baar call kiya
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        // Dusri baar call kiya
        Logger logger2 = Logger.getInstance();
        logger2.log("Doing some work...");

        // Check karte hain ki dono same hain ya nahi
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the same singleton instance.");
        }
    }
}