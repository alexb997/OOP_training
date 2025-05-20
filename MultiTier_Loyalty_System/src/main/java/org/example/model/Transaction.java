package org.example.model;

public class Transaction {
    private final double amount;
    private final int pointsEarned;
    private final int pointsRedeemed;

    public Transaction(double amount, int pointsEarned, int pointsRedeemed) {
        this.amount = amount;
        this.pointsEarned = pointsEarned;
        this.pointsRedeemed = pointsRedeemed;
    }

    public double getAmount() {
        return amount;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public int getPointsRedeemed() {
        return pointsRedeemed;
    }
}
