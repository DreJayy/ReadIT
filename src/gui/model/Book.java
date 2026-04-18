package gui.model;

public class Book {
    public String title;
    public String author;
    public int pages;
    public boolean borrowed;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.borrowed = false;
    }

    public String classify() {
        return pages < 200 ? "Short" : "Long";
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + pages + " pages)" + (borrowed ? " [borrowed]" : "");
    }
}
