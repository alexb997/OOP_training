package org.example.promotion;

import org.example.model.Dish;

import java.util.List;

public interface Promotion {
    double apply(List<Dish> items, double totalAmount);
    String getDescription();
}