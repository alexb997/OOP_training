package org.example.discount;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public class PromotionCodeStrategy implements DiscountStrategy {
    private final String promoCode;

    public PromotionCodeStrategy(String promoCode) {
        this.promoCode = promoCode;
    }

    public double getDiscount(Customer customer, List<Product> products) {
        if (promoCode.equalsIgnoreCase("SAVE10")) {
            return products.stream().mapToDouble(Product::getPrice).sum() * 0.10;
        }
        return 0;
    }
}
