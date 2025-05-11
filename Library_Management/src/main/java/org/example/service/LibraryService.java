package org.example.service;

import org.example.model.*;
import org.example.model.*;

import java.time.LocalDate;
import java.util.*;

public class LibraryService {
    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, Book> books = new HashMap<>();

    public void registerStudent(String name) {
        members.put(name, new Student(name));
    }

    public void registerProfessor(String name) {
        members.put(name, new Professor(name));
    }

    public void addBook(String title, String author, String isbn) {
        books.put(isbn, new Book(title, author, isbn));
    }

    public void borrowBook(String memberName, String isbn) {
        Member member = members.get(memberName);
        Book book = books.get(isbn);

        if (member == null || book == null) {
            System.out.println("Invalid member or book.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrow limit reached.");
            return;
        }

        boolean success = book.borrow(member, LocalDate.now().toEpochDay());
        if (success) {
            member.borrowBook(book);
            System.out.println(memberName + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(String memberName, String isbn) {
        Member member = members.get(memberName);
        Book book = books.get(isbn);

        if (member == null || book == null || book.isAvailable()) {
            System.out.println("Invalid return.");
            return;
        }

        book.returnBook();
        member.returnBook(book);
        System.out.println(memberName + " returned: " + book.getTitle());
    }

    public void viewBorrowedBooks() {
        books.values().stream()
                .filter(book -> !book.isAvailable())
                .forEach(book -> System.out.println(
                        book.getTitle() + " → Borrowed by " + book.getBorrowedBy().getName()));
    }

    public void calculateFines() {
        long currentDay = LocalDate.now().toEpochDay();

        for (Member member : members.values()) {
            for (Book book : member.getBorrowedBooks()) {
                double fine = member.calculateFine(book.getBorrowDate(), currentDay);
                if (fine > 0) {
                    System.out.println(member.getName() + "'s fine for '" +
                            book.getTitle() + "': $" + fine);
                }
            }
        }
    }
}
