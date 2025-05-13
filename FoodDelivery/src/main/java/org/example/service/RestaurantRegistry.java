package org.example.service;

import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantRegistry {
    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant findRestaurantByName(String name) {
        return restaurants.stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }
}