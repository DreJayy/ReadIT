public class Book {
    String title;
    String author;
    int pages;
    boolean borrowed = false;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String classify() {
        return pages > 300 ? "Long" : "Short";
    }

    public String status() {
        return borrowed ? "Borrowed" : "Available";
    }

    public String toString() {
        return title + " | " + author + " | " + pages + " pages | " + classify() + " | " + status();
    }
}