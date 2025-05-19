package org.example.loyalty;

public class FifteenPercentLoyalty implements LoyaltyPointStrategy {
    @Override
    public int calculate(double price, double discount) {
        return (int)(price / 15);
    }
}