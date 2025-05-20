package org.example.service;

import org.example.discount.DiscountStrategy;
import org.example.loyalty.LoyaltyPointsManager;
import org.example.model.*;

import java.util.List;

public class ShopService {
    private final DiscountStrategy discountStrategy;
    private final LoyaltyPointsManager pointsManager;

    public ShopService(DiscountStrategy discountStrategy, LoyaltyPointsManager pointsManager) {
        this.discountStrategy = discountStrategy;
        this.pointsManager = pointsManager;
    }

    public Order checkout(Customer customer, List<Product> products) {
        pointsManager.applyExpiryPolicy(customer);
        double discount = discountStrategy.getDiscount(customer, products);
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        double discountedTotal = total - discount;

        int redeemablePoints = pointsManager.calculateRedeemablePoints(customer, discountedTotal);
        double finalPrice = discountedTotal - (redeemablePoints / 10.0);

        int earnedPoints = pointsManager.calculateEarnedPoints(customer, products);

        customer.redeemPoints(redeemablePoints);
        customer.addPoints(earnedPoints);
        customer.addTransaction(new Transaction(finalPrice, earnedPoints, redeemablePoints));

        return new Order(customer, products, finalPrice, earnedPoints, redeemablePoints);
    }
}
