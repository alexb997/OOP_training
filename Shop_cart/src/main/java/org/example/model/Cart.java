package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(item.getName())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void viewItems() {
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println("- " + item.getName() + " x" + item.getQuantity() +
                    " - $" + item.getTotalPrice());
        }
    }

    public double getTotal() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public List<Item> getItems() {
        return items;
    }
}
