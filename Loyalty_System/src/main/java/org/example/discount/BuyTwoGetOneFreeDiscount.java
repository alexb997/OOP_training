package org.example.discount;

import org.example.model.Product;

import java.util.List;

public class BuyTwoGetOneFreeDiscount implements Discount {
    @Override
    public double apply(Product product, List<Product> cartItems) {
        long count = cartItems.stream().filter(p -> p.getName().equals(product.getName())).count();
        if (count % 3 == 0) return product.getPrice();
        return 0;
    }
}