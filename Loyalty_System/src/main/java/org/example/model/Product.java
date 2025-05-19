package org.example.model;

import org.example.discount.Discount;
import org.example.loyalty.LoyaltyPointStrategy;

public class Product {
    private final String name;
    private final double price;
    private final Discount discount;
    private final LoyaltyPointStrategy loyaltyStrategy;

    public Product(String name, double price, Discount discount, LoyaltyPointStrategy loyaltyStrategy) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.loyaltyStrategy = loyaltyStrategy;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public LoyaltyPointStrategy getLoyaltyStrategy() {
        return loyaltyStrategy;
    }
}