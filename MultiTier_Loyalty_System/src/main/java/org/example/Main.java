package org.example;

import org.example.model.*;
import org.example.service.*;
import org.example.discount.*;
import org.example.loyalty.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CustomerRegistry registry = new CustomerRegistry();
        ShopService shop = new ShopService(new TierDiscountStrategy(), new LoyaltyPointsManager(new ExpiryPolicy(), new RedemptionPolicy()));

        Customer customer = new Customer("Alice", MembershipTier.SILVER);
        registry.registerCustomer(customer);

        Product apple = new Product("Apple", 2.0);
        Product banana = new Product("Banana", 3.0);

        List<Product> cart = List.of(apple, banana);
        Order order = shop.checkout(customer, cart);

        System.out.println("Total Price: " + order.totalPrice());
        System.out.println("Points Earned: " + order.pointsEarned());
        System.out.println("Points Redeemed: " + order.pointsRedeemed());
    }
}
