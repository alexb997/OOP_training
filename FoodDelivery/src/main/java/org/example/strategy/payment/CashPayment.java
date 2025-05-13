package org.example.strategy.payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount + ". Please pay upon delivery.");
    }
}