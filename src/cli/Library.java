public class Library {
    Book[] books = new Book[100];
    int count = 0;

    public void addBook(String title, String author, int pages) {
        books[count++] = new Book(title, author, pages);
    }

    public void viewBooks() {
        if (count == 0) { System.out.println("No books yet."); return; }
        for (int i = 0; i < count; i++) System.out.println(books[i]);
    }

    public void searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + books[i]);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void classifyBooks() {
        System.out.println("-- Short Books --");
        for (int i = 0; i < count; i++)
            if (books[i].classify().equals("Short")) System.out.println(books[i]);

        System.out.println("-- Long Books --");
        for (int i = 0; i < count; i++)
            if (books[i].classify().equals("Long")) System.out.println(books[i]);
    }

    public void borrowBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (books[i].borrowed) System.out.println("Already borrowed.");
                else { books[i].borrowed = true; System.out.println("Borrowed successfully!"); }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}