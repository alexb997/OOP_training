package org.example.model;

public class Professor extends Member {
    public Professor(String name) {
        super(name);
        // TODO
    }

    @Override
    public int getBorrowLimit() {
        // TODO
        return 0;
    }

    @Override
    public int getLoanDays() {
        // TODO
        return 0;
    }

    @Override
    public double getFinePerDay() {
        // TODO
        return 0;
    }
}
