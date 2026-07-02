package com.practice.week1.testing;

public class PaymentService {

    /** External dependency we don't want to hit in a unit test — we'll mock this. */
    public interface PaymentGateway {
        boolean charge(String cardNumber, double amount);
    }

    private final PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String processPayment(String cardNumber, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        boolean success = gateway.charge(cardNumber, amount);
        return success ? "SUCCESS" : "FAILED";
    }
}
