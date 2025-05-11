package org.example.cli;

import org.example.model.*;
import org.example.service.LibraryService;

import java.util.Scanner;

public class LibraryCLI{
    private final LibraryService library = new LibraryService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        // TODO: Display CLI menu loop
        // 1. Register Member
        // 2. Add Book
        // 3. Borrow Book
        // 4. Return Book
        // 5. View Borrowed Books
        // 6. Exit
        System.out.println("Welcome to Library System");

        while (true) {
            System.out.println("""
                1. Register Student
                2. Register Professor
                3. Add Book
                4. Borrow Book
                5. Return Book
                6. View Borrowed Books
                7. Calculate Fines
                8. Exit
            """);
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> library.registerStudent(prompt("Enter student name: "));
                case "2" -> library.registerProfessor(prompt("Enter professor name: "));
                case "3" -> library.addBook(
                        prompt("Title: "), prompt("Author: "), prompt("ISBN: "));
                case "4" -> library.borrowBook(prompt("Member name: "), prompt("ISBN: "));
                case "5" -> library.returnBook(prompt("Member name: "), prompt("ISBN: "));
                case "6" -> library.viewBorrowedBooks();
                case "7" -> library.calculateFines();
                case "8" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private String prompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
    // TODO: Define helper methods: registerMember, addBook, borrowBook, returnBook
}
