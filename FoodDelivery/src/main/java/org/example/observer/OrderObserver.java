package org.example.observer;

import org.example.model.Order;

public interface OrderObserver {
    void update(Order order);
}