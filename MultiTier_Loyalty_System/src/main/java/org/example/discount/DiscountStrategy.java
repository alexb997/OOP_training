package org.example.discount;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public interface DiscountStrategy {
    double getDiscount(Customer customer, List<Product> products);
}
