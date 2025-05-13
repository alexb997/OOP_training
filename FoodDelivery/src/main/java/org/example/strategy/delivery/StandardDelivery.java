package org.example.strategy.delivery;

public class StandardDelivery implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost() {
        return 5.0;
    }
}