package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        for (Item i : items) {
            if (i.getName().equalsIgnoreCase(item.getName())) {
                items.remove(i);
                items.add(new Item(i.getName(), i.getPrice(), i.getQuantity() + item.getQuantity()));
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(i -> i.getName().equalsIgnoreCase(itemName));
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
    }

    public List<Item> getItems() {
        return items;
    }
}
