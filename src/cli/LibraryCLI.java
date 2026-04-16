import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Classify Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Save Report");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("Title: "); String title = sc.nextLine();
                System.out.print("Author: "); String author = sc.nextLine();
                System.out.print("Pages: "); int pages = Integer.parseInt(sc.nextLine());
                lib.addBook(title, author, pages);
                System.out.println("Book added!");
            } else if (choice == 2) {
                lib.viewBooks();
            } else if (choice == 3) {
                System.out.print("Title: "); lib.searchBook(sc.nextLine());
            } else if (choice == 4) {
                lib.classifyBooks();
            } else if (choice == 5) {
                System.out.print("Title: "); lib.borrowBook(sc.nextLine());
            } else if (choice == 6) {
                ReportSaver.save(lib);
            } else if (choice == 7) {
                System.out.println("Goodbye!");
            }
        } while (choice != 7);

        sc.close();
    }
}