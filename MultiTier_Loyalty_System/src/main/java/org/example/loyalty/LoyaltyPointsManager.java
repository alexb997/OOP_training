package org.example.loyalty;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public class LoyaltyPointsManager {
    private final ExpiryPolicy expiryPolicy;
    private final RedemptionPolicy redemptionPolicy;

    public LoyaltyPointsManager(ExpiryPolicy expiryPolicy, RedemptionPolicy redemptionPolicy) {
        this.expiryPolicy = expiryPolicy;
        this.redemptionPolicy = redemptionPolicy;
    }

    public int calculateEarnedPoints(Customer customer, List<Product> products) {
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        return (int) (total * (0.05 + customer.getTier().ordinal() * 0.05));
    }

    public int calculateRedeemablePoints(Customer customer, double totalPrice) {
        return redemptionPolicy.getRedeemablePoints(customer, totalPrice);
    }

    public void applyExpiryPolicy(Customer customer) {
        expiryPolicy.apply(customer);
    }
}
