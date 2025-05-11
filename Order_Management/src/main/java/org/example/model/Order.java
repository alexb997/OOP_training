package org.example.model;

import org.example.payment.PaymentStrategy;

public class Order {
    private Cart cart;
    private OrderStatus status;
    private PaymentStrategy paymentStrategy;

    public Order(Cart cart, PaymentStrategy paymentStrategy) {
        this.cart = cart;
        this.paymentStrategy = paymentStrategy;
        this.status = OrderStatus.PENDING;
    }

    public void placeOrder(double amount) {
        paymentStrategy.pay(amount);
        this.status = OrderStatus.CONFIRMED;
    }

    public void trackStatus() {
        System.out.println("Order Status: " + status);
    }

    public void nextStatus() {
        switch (status) {
            case PENDING -> status = OrderStatus.CONFIRMED;
            case CONFIRMED -> status = OrderStatus.SHIPPED;
            case SHIPPED -> status = OrderStatus.DELIVERED;
            case DELIVERED -> System.out.println("Order already delivered.");
        }
    }
}
