package org.example.model;

import org.example.promotion.Promotion;
import org.example.strategy.delivery.DeliveryStrategy;
import org.example.strategy.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Customer customer;
    private Map<Dish, Integer> items = new HashMap<>();
    private DeliveryStrategy deliveryStrategy;
    private PaymentStrategy paymentStrategy;
    private Promotion appliedPromotion;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItem(Dish dish, int quantity) {
        items.put(dish, items.getOrDefault(dish, 0) + quantity);
    }

    public Map<Dish, Integer> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Dish, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        if (appliedPromotion != null) {
            total = appliedPromotion.apply(new ArrayList<>(items.keySet()), total);
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void applyPromotion(Promotion promotion) {
        this.appliedPromotion = promotion;
    }

    public Promotion getAppliedPromotion() {
        return appliedPromotion;
    }
}