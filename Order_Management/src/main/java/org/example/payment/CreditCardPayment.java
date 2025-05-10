package org.example.payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardHolder;
    private String cardNumber;

    public CreditCardPayment(String cardHolder, String cardNumber) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        // TODO: Implement payment logic
    }
}
