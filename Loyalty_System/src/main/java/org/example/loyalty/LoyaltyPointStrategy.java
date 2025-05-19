package org.example.loyalty;

public interface LoyaltyPointStrategy {
    int calculate(double price, double discount);
}