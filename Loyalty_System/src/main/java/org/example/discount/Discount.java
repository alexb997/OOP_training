package org.example.discount;

import org.example.model.Product;

import java.util.List;

public interface Discount {
    double apply(Product product, List<Product> cartItems);
}