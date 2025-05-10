package org.example.service;
import org.example.util.DiscountCodes;

public class DiscountService {

    public double applyDiscount(String code, double totalAmount) {
        if (DiscountCodes.isValidCode(code)) {
            double discount = DiscountCodes.getDiscountValue(code);
            return totalAmount - (totalAmount * discount);
        }
        System.out.println("Invalid discount code. No discount applied.");
        return totalAmount;
    }
}
