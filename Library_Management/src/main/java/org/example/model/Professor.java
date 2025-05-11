package org.example.model;

public class Professor extends Member {
    public Professor(String name) {
        super(name);
    }

    @Override
    public int getMaxBooks() { return 5; }

    @Override
    public int getDueDays() { return 28; }

    @Override
    public double getFineRate() { return 0.5; }
}
