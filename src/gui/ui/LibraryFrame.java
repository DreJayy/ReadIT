package gui.ui;

import gui.model.Library;
import gui.model.Book;
import gui.utils.ReportSaver;

import javax.swing.*;
import java.awt.*;

public class LibraryFrame extends JFrame {
    private final Library library;
    private final DefaultListModel<Book> listModel = new DefaultListModel<>();
    private final JList<Book> bookList = new JList<>(listModel);

    public LibraryFrame() {
        super("Library GUI Template");
        this.library = new Library();
        initUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setLayout(new BorderLayout());

        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addBtn = new JButton("Add");
        JButton searchBtn = new JButton("Search");
        JButton borrowBtn = new JButton("Borrow");
        JButton classifyBtn = new JButton("Classify");
        JButton saveBtn = new JButton("Save Report");

        controls.add(addBtn);
        controls.add(searchBtn);
        controls.add(borrowBtn);
        controls.add(classifyBtn);
        controls.add(saveBtn);

        add(controls, BorderLayout.SOUTH);

    addBtn.addActionListener(e -> onAdd());
    searchBtn.addActionListener(e -> onSearch());
    borrowBtn.addActionListener(e -> onBorrow());
    classifyBtn.addActionListener(e -> onClassify());
    saveBtn.addActionListener(e -> ReportSaver.save(library));
    }

    private void onAdd() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField pagesField = new JTextField();

        Object[] message = {"Title:", titleField, "Author:", authorField, "Pages:", pagesField};
        int option = JOptionPane.showConfirmDialog(this, message, "Add Book", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            int pages = 0;
            try {
                pages = Integer.parseInt(pagesField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Pages must be a number.");
                return;
            }
            library.addBook(title, author, pages);
            updateList();
        }
    }

    private void onSearch() {
        String title = JOptionPane.showInputDialog(this, "Enter title to search:");
        if (title == null) return;
        Book b = library.searchBook(title);
        JOptionPane.showMessageDialog(this, b == null ? "Book not found." : "Found: " + b);
    }

    private void onBorrow() {
        String title = JOptionPane.showInputDialog(this, "Enter title to borrow:");
        if (title == null) return;
        boolean ok = library.borrowBook(title);
        JOptionPane.showMessageDialog(this, ok ? "Borrowed successfully!" : "Not available or not found.");
        updateList();
    }

    private void onClassify() {
        Book[] shorts = library.classifyBooks("Short");
        Book[] longs = library.classifyBooks("Long");
        StringBuilder sb = new StringBuilder("-- Short Books --\n");
        if (shorts != null) {
            for (int i = 0; i < shorts.length; i++) {
                Book b = shorts[i];
                sb.append(b).append('\n');
            }
        }
        sb.append('\n').append("-- Long Books --\n");
        if (longs != null) {
            for (int i = 0; i < longs.length; i++) {
                Book b = longs[i];
                sb.append(b).append('\n');
            }
        }
        JTextArea ta = new JTextArea(sb.toString());
        ta.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(ta), "Classification", JOptionPane.PLAIN_MESSAGE);
    }

    private void updateList() {
        listModel.clear();
        Book[] books = library.getBooks();
        if (books != null) {
            for (int i = 0; i < books.length; i++) {
                listModel.addElement(books[i]);
            }
        }
    }
}
