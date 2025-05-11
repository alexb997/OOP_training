package org.example.model;

public class Student extends Member {
    public Student(String name) {
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