package org.example.model;

import org.example.strategy.delivery.DeliveryStrategy;
import org.example.strategy.payment.PaymentStrategy;

import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private OrderStatus status;
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;
    private double totalAmount;

    public Order(Customer customer, List<OrderItem> items, PaymentStrategy paymentStrategy, DeliveryStrategy deliveryStrategy, double totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = items;
        this.status = OrderStatus.PENDING;
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}