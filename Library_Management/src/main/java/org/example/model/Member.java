package org.example.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Member implements FinesApplicable{
    protected final String name;
    protected final List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public abstract int getMaxBooks();
    public abstract int getDueDays();
    public abstract double getFineRate();

    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < getMaxBooks();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public double calculateFine(long borrowedDay, long currentDay) {
        long daysLate = currentDay - borrowedDay - getDueDays();
        return Math.max(0, daysLate * getFineRate());
    }
}
