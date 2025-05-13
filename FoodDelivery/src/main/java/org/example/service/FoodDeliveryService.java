package org.example.service;

import org.example.model.*;
import org.example.observer.CustomerNotification;
import org.example.observer.OrderSubject;
import org.example.promotion.Promotion;
import org.example.promotion.PromotionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodDeliveryService {
    private final RestaurantRegistry restaurantRegistry = new RestaurantRegistry();
    private final Map<String, Order> orders = new HashMap<>();
    private final OrderSubject orderSubject = new OrderSubject();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Promotion> availablePromotions = new ArrayList<>();

    public FoodDeliveryService() {
        availablePromotions.add(PromotionFactory.createPercentageDiscount("SUMMER20", 20));
        availablePromotions.add(PromotionFactory.createBOGODiscount("BOGO_PIZZA", "Pizza"));
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurantRegistry.addRestaurant(restaurant);
    }

    public Restaurant findRestaurantByName(String name) {
        return restaurantRegistry.findRestaurantByName(name);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
        orderSubject.attach(new CustomerNotification(customer.getName()));
    }

    public void addPromotion(Promotion promotion) {
        availablePromotions.add(promotion);
    }

    public List<Promotion> getAvailablePromotions() {
        return availablePromotions;
    }

    public Order placeOrder(Customer customer, Cart cart) {
        List<OrderItem> orderItems = cart.getItems().entrySet().stream()
                .map(entry -> new OrderItem(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        double totalAmount = cart.calculateTotal();
        Order order = new Order(customer, orderItems, cart.getPaymentStrategy(), cart.getDeliveryStrategy(), totalAmount);
        orders.put(order.getOrderId(), order);
        orderSubject.notifyObservers(order);
        return order;
    }

    public Order trackOrder(String orderId) {
        return orders.get(orderId);
    }

    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            orderSubject.notifyObservers(order);
        }
    }

    public RestaurantRegistry findRestaurantRegistry() {
        return restaurantRegistry;
    }

    public Map<String, Order> getAllOrders() {
        return orders;
    }
}