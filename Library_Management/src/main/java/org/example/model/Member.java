package org.example.model;

import java.util.List;

public abstract class Member {
    protected String name;
    protected List<Book> borrowedBooks;

    public Member(String name) {
        // TODO: Initialize fields
    }

    public String getName() {
        // TODO
        return null;
    }

    public List<Book> getBorrowedBooks() {
        // TODO
        return null;
    }

    public abstract int getBorrowLimit();
    public abstract int getLoanDays();
    public abstract double getFinePerDay();
}
