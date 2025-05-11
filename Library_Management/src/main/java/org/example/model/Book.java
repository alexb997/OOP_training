package org.example.model;

public class Book implements Borrowable{
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isAvailable = true;
    private Member borrowedBy;
    private long borrowDate;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public boolean borrow(Member member, long currentDay) {
        if (!isAvailable) return false;
        isAvailable = false;
        borrowedBy = member;
        borrowDate = currentDay;
        return true;
    }

    @Override
    public boolean returnBook() {
        if (isAvailable) return false;
        isAvailable = true;
        borrowedBy = null;
        borrowDate = 0;
        return true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public Member getBorrowedBy() { return borrowedBy; }
    public long getBorrowDate() { return borrowDate; }
}
