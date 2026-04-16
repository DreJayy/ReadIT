import java.io.FileWriter;
import java.io.IOException;

public class ReportSaver {
    public static void save(Library lib) {
        try (FileWriter fw = new FileWriter("library_report.txt")) {
            fw.write("===== LIBRARY REPORT =====\n");
            for (int i = 0; i < lib.count; i++) fw.write(lib.books[i] + "\n");
            System.out.println("Saved to library_report.txt");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
