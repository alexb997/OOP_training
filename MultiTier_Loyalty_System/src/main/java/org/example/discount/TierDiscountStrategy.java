package org.example.discount;

import org.example.model.Customer;
import org.example.model.MembershipTier;
import org.example.model.Product;

import java.util.List;

public class TierDiscountStrategy implements DiscountStrategy {
    public double getDiscount(Customer customer, List<Product> products) {
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        return switch (customer.getTier()) {
            case STANDARD -> 0;
            case SILVER -> total * 0.05;
            case GOLD -> total * 0.10;
            case PLATINUM -> total * 0.15;
        };
    }
}
