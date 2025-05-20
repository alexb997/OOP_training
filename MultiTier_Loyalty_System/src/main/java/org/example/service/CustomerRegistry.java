package org.example.service;

import org.example.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRegistry {
    private final Map<String, Customer> customers = new HashMap<>();

    public void registerCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    public Customer getCustomer(String name) {
        return customers.get(name);
    }
}
