package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Dish> menu = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public void updateAvailability(String dishName, boolean isAvailable) {
        System.out.println("Availability update for " + dishName + " to " + isAvailable + " (not fully implemented in this example).");
    }
}