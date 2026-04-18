package gui;

import javax.swing.SwingUtilities;
import gui.ui.LibraryFrame;

public class MainGui {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryFrame frame = new LibraryFrame();
            frame.setVisible(true);
        });
    }
}
