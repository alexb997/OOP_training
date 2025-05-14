package org.example.cli;

import java.util.Scanner;

public class CLIHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        System.out.println("Welcome to SmartCitySim - Urban Simulation System");

        while (running) {
            printMainMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> handleCitizenMenu();
                case "2" -> handleBusinessMenu();
                case "3" -> handleGovernmentMenu();
                case "0" -> {
                    System.out.println("Exiting simulation. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid input. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("""
            \n====== Main Menu ======
            1. Citizen Portal
            2. Business Portal
            3. Government Dashboard
            0. Exit
            Enter your choice:
            """);
    }

    private void handleCitizenMenu() {
        System.out.println("""
            \nCitizen Menu:
            1. Register as New Citizen
            2. View Profile
            3. Apply for City Services
            0. Back to Main Menu
            """);

        System.out.print("Enter your choice: ");
        switch (scanner.nextLine()) {
            case "1" -> System.out.println("[TODO] Citizen registration...");
            case "2" -> System.out.println("[TODO] View profile...");
            case "3" -> System.out.println("[TODO] Apply for services...");
            case "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid input.");
        }
    }

    private void handleBusinessMenu() {
        System.out.println("""
            \nBusiness Menu:
            1. Register a Business
            2. Apply for Permit
            0. Back to Main Menu
            """);

        System.out.print("Enter your choice: ");
        switch (scanner.nextLine()) {
            case "1" -> System.out.println("[TODO] Business registration...");
            case "2" -> System.out.println("[TODO] Apply for permit...");
            case "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid input.");
        }
    }

    private void handleGovernmentMenu() {
        System.out.println("""
            \nGovernment Dashboard:
            1. View City Statistics
            2. Approve Permits
            3. Manage Public Services
            0. Back to Main Menu
            """);

        System.out.print("Enter your choice: ");
        switch (scanner.nextLine()) {
            case "1" -> System.out.println("[TODO] View statistics...");
            case "2" -> System.out.println("[TODO] Approve permits...");
            case "3" -> System.out.println("[TODO] Manage services...");
            case "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid input.");
        }
    }
}
