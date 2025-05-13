package org.example.cli;

import org.example.model.*;
import org.example.promotion.Promotion;
import org.example.service.FoodDeliveryService;
import org.example.strategy.delivery.DeliveryStrategy;
import org.example.strategy.delivery.ExpressDelivery;
import org.example.strategy.delivery.StandardDelivery;
import org.example.strategy.payment.CashPayment;
import org.example.strategy.payment.CreditCardPayment;
import org.example.strategy.payment.PaymentStrategy;
import org.example.strategy.payment.UPIPayment;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CLIHandler {
    private final FoodDeliveryService foodDeliveryService = new FoodDeliveryService();
    private final Scanner scanner = new Scanner(System.in);
    private Customer currentCustomer;
    private Cart currentCart;

    public void run() {
        boolean running = true;

        System.out.println("🍽️ Welcome to QuickEats!");

        while (running) {
            printMainMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> handleCustomerMenu();
                case "2" -> handleRestaurantMenu();
                case "3" -> handleAdminMenu();
                case "0" -> {
                    System.out.println("Exiting. Thank you!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n====== Main Menu ======");
        System.out.println("1. Customer");
        System.out.println("2. Restaurant");
        System.out.println("3. Admin");
        System.out.println("0. Exit");
    }

    private void handleCustomerMenu() {
        boolean inCustomerMenu = true;
        while (inCustomerMenu) {
            printCustomerMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> registerCustomer();
                case "2" -> browseMenu();
                case "3" -> addToCart();
                case "4" -> applyPromotion();
                case "5" -> choosePaymentAndDelivery();
                case "6" -> placeOrder();
                case "7" -> trackOrder();
                case "0" -> inCustomerMenu = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printCustomerMenu() {
        System.out.println("\nCustomer Menu:");
        System.out.println("1. Register");
        System.out.println("2. Browse Menu");
        System.out.println("3. Add to Cart");
        System.out.println("4. Apply Promotion");
        System.out.println("5. Choose Payment & Delivery");
        System.out.println("6. Place Order");
        System.out.println("7. Track Order");
        System.out.println("0. Back to Main Menu");
    }

    private void handleRestaurantMenu() {
        boolean inRestaurantMenu = true;
        while (inRestaurantMenu) {
            printRestaurantMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> registerRestaurant();
                case "2" -> addDish();
                case "0" -> inRestaurantMenu = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printRestaurantMenu() {
        System.out.println("\nRestaurant Menu:");
        System.out.println("1. Register Restaurant");
        System.out.println("2. Add Dish");
        System.out.println("0. Back to Main Menu");
    }

    private void handleAdminMenu() {
        boolean inAdminMenu = true;
        while (inAdminMenu) {
            printAdminMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> viewAllRestaurants();
                case "2" -> viewAllOrders();
                case "0" -> inAdminMenu = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printAdminMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. View All Restaurants");
        System.out.println("2. View All Orders");
        System.out.println("0. Back to Main Menu");
    }

    private void registerRestaurant() {
        System.out.print("Enter restaurant name: ");
        String name = scanner.nextLine();
        foodDeliveryService.registerRestaurant(new Restaurant(name));
        System.out.println("Restaurant registered successfully!");
    }

    private void addDish() {
        System.out.print("Enter restaurant name: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = foodDeliveryService.findRestaurantByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Resstaurant not found.");
            return;
        }
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter dish price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter dish type (veg/non-veg): ");
        String type = scanner.nextLine();
        restaurant.addDish(new Dish(name, price, type));
        System.out.println("✅ Dish added successfully!");
    }

    private void registerCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        currentCustomer = new Customer(name);
        foodDeliveryService.registerCustomer(currentCustomer);
        currentCart = new Cart(currentCustomer);
        System.out.println("✅ Customer registered successfully!");
    }

    private void browseMenu() {
        System.out.print("Enter restaurant name to browse menu: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = foodDeliveryService.findRestaurantByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        List<Dish> menu = restaurant.getMenu();
        if (menu.isEmpty()) {
            System.out.println("Menu is empty for this restaurant.");
            return;
        }
        System.out.println("Menu for " + restaurant.getName() + ":");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice() + " (" + menu.get(i).getType() + ")");
        }
    }

    private void addToCart() {
        if (currentCustomer == null) {
            System.out.println("Please register as a customer first (Customer Menu -> 1).");
            return;
        }
        System.out.print("Enter restaurant name to order from: ");
        String restaurantName = scanner.nextLine();
        Restaurant restaurant = foodDeliveryService.findRestaurantByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }
        List<Dish> menu = restaurant.getMenu();
        if (menu.isEmpty()) {
            System.out.println("Menu is empty for this restaurant.");
            return;
        }
        System.out.print("Enter the number of the dish to add to cart: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            return;
        }
        int dishNumber = scanner.nextInt();
        scanner.nextLine();
        if (dishNumber > 0 && dishNumber <= menu.size()) {
            Dish selectedDish = menu.get(dishNumber - 1);
            System.out.print("Enter quantity: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                return;
            }
            int quantity = scanner.nextInt();
            scanner.nextLine();
            currentCart.addItem(selectedDish, quantity);
            System.out.println(selectedDish.getName() + " x " + quantity + " added to cart.");
        } else {
            System.out.println("Invalid dish number.");
        }
    }

    private void applyPromotion() {
        if (currentCart == null || currentCart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Add items to apply promotions.");
            return;
        }
        List<Promotion> availablePromotions = foodDeliveryService.getAvailablePromotions();
        if (availablePromotions.isEmpty()) {
            System.out.println("No promotions available at the moment.");
            return;
        }
        System.out.println("Available Promotions:");
        for (int i = 0; i < availablePromotions.size(); i++) {
            System.out.println((i + 1) + ". " + availablePromotions.get(i).getDescription());
        }
        System.out.print("Enter the number of the promotion to apply (0 for none): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            scanner.nextLine();
            return;
        }
        int promotionNumber = scanner.nextInt();
        scanner.nextLine();
        if (promotionNumber > 0 && promotionNumber <= availablePromotions.size()) {
            Promotion selectedPromotion = availablePromotions.get(promotionNumber - 1);
            currentCart.applyPromotion(selectedPromotion);
            System.out.println("Promotion '" + selectedPromotion.getDescription() + "' applied.");
        } else if (promotionNumber != 0) {
            System.out.println("Invalid promotion number.");
        } else {
            System.out.println("No promotion applied.");
        }
    }

    private void choosePaymentAndDelivery() {
        if (currentCart == null || currentCart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Add items before choosing payment and delivery.");
            return;
        }

        System.out.println("Choose Delivery Method:");
        System.out.println("1. Standard Delivery");
        System.out.println("2. Express Delivery");
        System.out.print("Enter your choice: ");
        String deliveryChoice = scanner.nextLine();

        DeliveryStrategy deliveryStrategy;
        if (deliveryChoice.equals("1")) {
            deliveryStrategy = new StandardDelivery();
        } else if (deliveryChoice.equals("2")) {
            deliveryStrategy = new ExpressDelivery();
        } else {
            System.out.println("Invalid delivery choice. Using Standard Delivery.");
            deliveryStrategy = new StandardDelivery();
        }

        System.out.println("Choose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        System.out.println("3. UPI");
        System.out.print("Enter your choice: ");
        String paymentChoice = scanner.nextLine();

        PaymentStrategy paymentStrategy;
        if (paymentChoice.equals("1")) {
            System.out.print("Enter credit card number: ");
            String cardNumber = scanner.nextLine();
            paymentStrategy = new CreditCardPayment(cardNumber);
        } else if (paymentChoice.equals("2")) {
            paymentStrategy = new CashPayment();
        } else if (paymentChoice.equals("3")) {
            System.out.print("Enter UPI ID: ");
            String upiId = scanner.nextLine();
            paymentStrategy = new UPIPayment(upiId);
        } else {
            System.out.println("Invalid payment choice. Using Cash Payment.");
            paymentStrategy = new CashPayment();
        }

        currentCart.setDeliveryStrategy(deliveryStrategy);
        currentCart.setPaymentStrategy(paymentStrategy);
        System.out.println("Payment and delivery methods chosen.");
    }

    private void placeOrder() {
        if (currentCart == null || currentCart.getItems().isEmpty() || currentCart.getPaymentStrategy() == null || currentCart.getDeliveryStrategy() == null) {
            System.out.println("Please add items to cart and choose payment/delivery methods first.");
            return;
        }
        Order order = foodDeliveryService.placeOrder(currentCustomer, currentCart);
        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
        currentCart = new Cart(currentCustomer);
    }

    private void trackOrder() {
        System.out.print("Enter your order ID: ");
        String orderId = scanner.nextLine();
        Order order = foodDeliveryService.trackOrder(orderId);
        if (order != null) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Items:");
            order.getItems().forEach(item ->
                    System.out.println("- " + item.getDish().getName() + " (Quantity: " + item.getQuantity() + ")")
            );
            System.out.println("Total Amount: $" + order.getTotalAmount());
        } else {
            System.out.println("Order not found with ID: " + orderId);
        }
    }

    private void viewAllRestaurants() {
        List<Restaurant> restaurants = foodDeliveryService.findRestaurantRegistry().getAllRestaurants();
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants registered yet.");
            return;
        }
        System.out.println("\n--- All Registered Restaurants ---");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant.getName());
        }
        System.out.println("------------------------------");
    }

    private void viewAllOrders() {
        Map<String, Order> orders = foodDeliveryService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("ℹ️ No orders placed yet.");
            return;
        }
        System.out.println("\n----- All Placed Orders -----");
        for (Order order : orders.values()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getName() + ", Status: " + order.getStatus() + ", Total: $" + order.getTotalAmount());
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        new CLIHandler().run();
    }
}