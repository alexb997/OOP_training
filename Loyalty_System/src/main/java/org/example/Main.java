package org.example;

import org.example.discount.*;
import org.example.loyalty.*;
import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");

        Product p1 = new Product("Product A", 100.0, new TenPercentDiscount(), new TenPercentLoyalty());
        Product p2 = new Product("Product B", 200.0, new FifteenPercentDiscount(), new FifteenPercentLoyalty());
        Product p3 = new Product("Product C", 50.0, new NoDiscount(), new NoDiscountLoyalty());
        Product p4 = new Product("Product D", 30.0, new BuyTwoGetOneFreeDiscount(), new NoDiscountLoyalty());

        ShoppingCart cart = new ShoppingCart(customer);
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.addProduct(p4);
        cart.addProduct(p4);
        cart.addProduct(p4);

        System.out.println(cart);
        Order order = cart.checkout();
        System.out.println(order);
    }
}
