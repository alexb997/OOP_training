package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Customer customer;
    private final List<Product> products;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order checkout() {
        double total = 0;
        int points = 0;

        for (Product product : products) {
            double discount = product.getDiscount().apply(product, products);
            total += product.getPrice() - discount;
            points += product.getLoyaltyStrategy().calculate(product.getPrice(), discount);
        }

        return new Order(total, points);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer: " + customer.getName() + "\nProducts:\n");
        for (Product p : products) {
            sb.append("- ").append(p.getName()).append(": ").append(p.getPrice()).append("\n");
        }
        return sb.toString();
    }
}