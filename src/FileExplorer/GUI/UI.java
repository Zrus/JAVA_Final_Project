package FileExplorer.GUI;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    //Main components
    JMenuBar menuBar;

    public UI() {
        setTitle("File Explorer");
        setPreferredSize(new Dimension(800, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setJMenuBar(menuBar);
        setVisible(true);
        pack();
    }

    void initMenuBar() {
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu();
        JMenu homeMenu = new JMenu();
        JMenu shareMenu = new JMenu();
        JMenu viewMenu = new JMenu();


    }

}
