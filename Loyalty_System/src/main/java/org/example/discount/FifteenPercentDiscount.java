package org.example.discount;

import org.example.model.Product;

import java.util.List;

public class FifteenPercentDiscount implements Discount {
    @Override
    public double apply(Product product, List<Product> cartItems) {
        return product.getPrice() * 0.15;
    }
}