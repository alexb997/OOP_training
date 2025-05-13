package org.example.promotion;

import org.example.model.Dish;

import java.util.List;

public class PercentageDiscount implements Promotion {
    private String name;
    private double discountPercentage;

    public PercentageDiscount(String name, double discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage / 100.0;
    }

    @Override
    public double apply(List<Dish> items, double totalAmount) {
        return totalAmount * (1 - discountPercentage);
    }

    @Override
    public String getDescription() {
        return name + ": " + (discountPercentage * 100) + "% off";
    }
}