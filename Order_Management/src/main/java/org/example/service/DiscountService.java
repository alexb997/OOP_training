package org.example.service;

import java.util.HashMap;
import java.util.Map;

public class DiscountService {

    private static final Map<String, Double> DISCOUNT_CODES = new HashMap<>();

    static {
        DISCOUNT_CODES.put("WELCOME10", 0.10);
        DISCOUNT_CODES.put("SAVE20", 0.20);
    }

    public double applyDiscount(String code, double totalAmount) {
        if (DISCOUNT_CODES.containsKey(code)) {
            double discount = DISCOUNT_CODES.get(code);
            return totalAmount - (totalAmount * discount);
        }
        return totalAmount;
    }
}
