package org.example.loyalty;

public class NoDiscountLoyalty implements LoyaltyPointStrategy {
    @Override
    public int calculate(double price, double discount) {
        return (int)(price / 5);
    }
}