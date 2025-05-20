package org.example.model;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<Product> products;
    private final double totalPrice;
    private final int pointsEarned;
    private final int pointsRedeemed;

    public Order(Customer customer, List<Product> products, double totalPrice, int pointsEarned, int pointsRedeemed) {
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.pointsEarned = pointsEarned;
        this.pointsRedeemed = pointsRedeemed;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int pointsEarned() {
        return pointsEarned;
    }

    public int pointsRedeemed() {
        return pointsRedeemed;
    }
}
