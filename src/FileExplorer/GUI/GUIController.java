package FileExplorer.GUI;

import javax.swing.*;

public class GUIController {

    JFrame mainFrame;

    public GUIController(JFrame frame) {
        mainFrame = frame;
    }

    void showHelp() {
        JOptionPane.showMessageDialog( mainFrame,
                "File Explorer v0.1");
    }

    void close() {
        mainFrame.dispose();
    }

}
