package org.example.loyalty;

public class TenPercentLoyalty implements LoyaltyPointStrategy {
    @Override
    public int calculate(double price, double discount) {
        return (int)(price / 10);
    }
}