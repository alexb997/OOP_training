package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final MembershipTier tier;
    private int loyaltyPoints;
    private final List<Transaction> transactions = new ArrayList<>();

    public Customer(String name, MembershipTier tier) {
        this.name = name;
        this.tier = tier;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addPoints(int points) {
        loyaltyPoints += points;
    }

    public void redeemPoints(int points) {
        loyaltyPoints -= points;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
