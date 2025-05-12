package org.example.promotion;

public class PercentageDiscount implements Promotion {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double total) {
        return total - (total * percent / 100);
    }
}
