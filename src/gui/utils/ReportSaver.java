package gui.utils;

import gui.model.Library;
import gui.model.Book;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportSaver {
    public static void save(Library lib) {
        Book[] books = lib.getBooks();

        StringBuilder sb = new StringBuilder();
        sb.append("===== LIBRARY REPORT =====").append(System.lineSeparator());

        if (books == null || books.length == 0) {
            sb.append("No books available").append(System.lineSeparator());
        } else {
            for (int i = 0; i < books.length; i++) {
                Book b = books[i];
                if (b != null) {
                    sb.append(b.toString()).append(System.lineSeparator());
                } else {
                    sb.append("null").append(System.lineSeparator());
                }
            }
        }

        Path out = Paths.get("library_report.txt");
        try {
            Files.writeString(out, sb.toString());
            System.out.println("Saved to " + out.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving report: " + e.getMessage());
        }
    }
}
