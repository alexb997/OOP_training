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

    public void placeOrder() {
        // TODO: Call paymentStrategy.pay()
        // TODO: Update order status
    }

    public void trackStatus() {
        // TODO: Print current status
    }
}
