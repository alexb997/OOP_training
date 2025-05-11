package org.example.model;

public interface Borrowable {
    boolean borrow(Member member, long currentDay);
    boolean returnBook();
}