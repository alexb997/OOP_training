package org.example.loyalty;

import org.example.model.Customer;

public class RedemptionPolicy {
    public int getRedeemablePoints(Customer customer, double totalPrice) {
        int maxRedeem = (int) totalPrice * 10;
        return Math.min(customer.getLoyaltyPoints(), maxRedeem);
    }
}
