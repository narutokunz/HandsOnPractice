package com.practice.week1.designpatterns;

/**
 * STRATEGY PATTERN
 * Defines a family of interchangeable algorithms and lets the client pick one at runtime,
 * instead of hardcoding if/else chains.
 */
public class StrategyPatternDemo {

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Credit Card");
        }
    }

    static class UpiPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using UPI");
        }
    }

    static class Checkout {
        private final PaymentStrategy strategy;
        Checkout(PaymentStrategy strategy) { this.strategy = strategy; }
        void checkout(double amount) { strategy.pay(amount); }
    }

    public static void main(String[] args) {
        new Checkout(new UpiPayment()).checkout(499.0);
        new Checkout(new CreditCardPayment()).checkout(2599.0);
    }
}
