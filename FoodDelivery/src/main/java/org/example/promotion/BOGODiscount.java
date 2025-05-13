package org.example.promotion;

import org.example.model.Dish;

import java.util.List;

public class BOGODiscount implements Promotion {
    private String name;
    private String appliesToDishName;

    public BOGODiscount(String name, String appliesToDishName) {
        this.name = name;
        this.appliesToDishName = appliesToDishName;
    }

    @Override
    public double apply(List<Dish> items, double totalAmount) {
        long count = items.stream().filter(item -> item.getName().equals(appliesToDishName)).count();
        long freeItems = count / 2;
        double discount = 0;
        int freeItemsApplied = 0;

        List<Dish> applicableItems = items.stream()
                .filter(item -> item.getName().equals(appliesToDishName))
                .sorted((d1, d2) -> Double.compare(d2.getPrice(), d1.getPrice()))
                .toList();

        for (Dish dish : applicableItems) {
            if (freeItemsApplied < freeItems) {
                discount += dish.getPrice();
                freeItemsApplied++;
            }
        }
        return totalAmount - discount;
    }

    @Override
    public String getDescription() {
        return name + ": Buy one get one free on " + appliesToDishName;
    }
}