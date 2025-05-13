package org.example.observer;

import org.example.model.Order;

public class CustomerNotification implements OrderObserver {
    private String customerName;

    public CustomerNotification(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(Order order) {
        System.out.println("Notification for " + customerName + ": Your order " + order.getOrderId() + " is now " + order.getStatus() + ".");
    }
}