package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        // TODO: Add or update quantity
    }

    public void removeItem(String itemName) {
        // TODO: Remove item by name
    }

    public double getTotal() {
        // TODO: Calculate total
        return 0;
    }

    public List<Item> getItems() {
        return items;
    }
}
