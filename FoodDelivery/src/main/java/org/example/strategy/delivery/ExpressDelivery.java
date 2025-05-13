package org.example.strategy.delivery;

public class ExpressDelivery implements DeliveryStrategy {
    @Override
    public double calculateDeliveryCost() {
        return 10.0;
    }
}