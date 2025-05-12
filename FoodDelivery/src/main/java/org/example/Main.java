package org.example;

import org.example.model.User;
import org.example.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<User> users = new ArrayList<>();
    private static final List<Restaurant> restaurants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Food Delivery System");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register User");
            System.out.println("2. Register Restaurant");
            System.out.println("3. Admin - View All Restaurants");
            System.out.println("0. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> registerUser(scanner);
                case "2" -> registerRestaurant(scanner);
                case "3" -> listRestaurants();
                case "0" -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter user email: ");
        String email = scanner.nextLine();

        users.add(new User(name, email));
        System.out.println("✅ User registered!");
    }

    private static void registerRestaurant(Scanner scanner) {
        System.out.print("Enter restaurant name: ");
        String name = scanner.nextLine();

        System.out.print("Enter restaurant address: ");
        String address = scanner.nextLine();

        restaurants.add(new Restaurant(name, address));
        System.out.println("✅ Restaurant registered!");
    }

    private static void listRestaurants() {
        System.out.println(restaurants);
        System.out.println("\n📋 Registered Restaurants:");
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found.");
        } else {
            for (Restaurant r : restaurants) {
                System.out.println("- " + r.getName() + " | " + r.getAddress());
            }
        }
    }
}
