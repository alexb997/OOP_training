package org.example.loyalty;

import org.example.model.Customer;

public class ExpiryPolicy {
    public void apply(Customer customer) {
        if (customer.getTransactions().size() > 5) {
            customer.redeemPoints((int) (customer.getLoyaltyPoints() * 0.2));
        }
    }
}
