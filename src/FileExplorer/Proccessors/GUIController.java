package FileExplorer.Proccessors;

import FileExplorer.GUI.UI;

import javax.swing.*;
import java.io.File;

public class GUIController {

    UI mainFrame;
    ItemList itemList;

    public GUIController(UI frame) {
        mainFrame = frame;
        itemList = new ItemList();
    }

    public void showHelp() {
        JOptionPane.showMessageDialog( mainFrame,
                "File Explorer v0.1");
    }

    public void close() {
        mainFrame.dispose();
    }

    public File[] returnItemList() {
        return itemList.items;
    }

}
