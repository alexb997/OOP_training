package org.example.model;

public class Student extends Member {
    public Student(String name) {
        super(name);
    }

    @Override
    public int getMaxBooks() {
        return 3;
    }

    @Override
    public int getDueDays() {
        return 14;
    }

    @Override
    public double getFineRate() {
        return 1.0;
    }
}