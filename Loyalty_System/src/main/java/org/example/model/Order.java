package org.example.model;

public class Order {
    private final double totalPrice;
    private final int loyaltyPoints;

    public Order(double totalPrice, int loyaltyPoints) {
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice + "\nLoyalty points earned: " + loyaltyPoints;
    }
}