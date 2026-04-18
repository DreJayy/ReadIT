package gui.model;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, int pages) {
        books.add(new Book(title, author, pages));
    }

    public Book[] getBooks() {
        return books.toArray(new Book[0]);
    }

    public Book searchBook(String title) {
        if (title == null) return null;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public Book[] classifyBooks(String kind) {
        if (kind == null) return new Book[0];
        return books.stream()
                .filter(b -> b.classify().equalsIgnoreCase(kind))
                .toArray(Book[]::new);
    }

    public boolean borrowBook(String title) {
        Book b = searchBook(title);
        if (b == null || b.borrowed) return false;
        b.borrowed = true;
        return true;
    }
}
