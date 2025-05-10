package org.example;

import org.example.model.Cart;
import org.example.model.Item;
import org.example.service.DiscountService;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Item("Laptop", 1200.00, 1));
        cart.addItem(new Item("Smartphone", 800.00, 2));
        cart.viewItems();

        DiscountService discountService = new DiscountService();
        double discountedTotal = discountService.applyDiscount("SUMMER10", cart.getTotal());
        System.out.println("Total Price after discount: $" + discountedTotal);
    }
}
