package org.example.promotion;

public class BOGODiscount implements Promotion {
    @Override
    public double apply(double total) {
        // TODO: Apply BOGO logic
        return total;
    }
}
