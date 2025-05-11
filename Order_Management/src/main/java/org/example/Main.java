package org.example;

import org.example.model.*;
import org.example.payment.*;
import org.example.service.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a cart, add items
        // TODO: Apply discount if needed
        // TODO: Choose a payment method
        // TODO: Place and track the order
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", 1200.0, 1));
        cart.addItem(new Item("Mouse", 25.0, 2));

        double totalBeforeDiscount = cart.getTotal();
        DiscountService discountService = new DiscountService();
        double discountedTotal = discountService.applyDiscount("WELCOME10", totalBeforeDiscount);

        PaymentStrategy payment = new CreditCardPayment("Basic Joe", "1234-5678-9876-5432");
        Order order = new Order(cart, payment);
        order.trackStatus();
        order.placeOrder(discountedTotal);
        order.trackStatus();

        order.nextStatus();
        order.trackStatus();

        order.nextStatus();
        order.trackStatus();

        order.nextStatus();
    }
}
