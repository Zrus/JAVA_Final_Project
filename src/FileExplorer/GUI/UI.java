package FileExplorer.GUI;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

    //GUI Controller
    GUIController controller;
    ListItemUI listItem;
    ItemPanelUI itemPanel;
    AddressBarUI addressBar;

    //Main components

    public UI() {
        setTitle("File Explorer");
        setPreferredSize(new Dimension(800, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);
        setVisible(true);

        controller = new GUIController(this);

        initMenuBar();
        initAddressBar();
        initListItem();
        initItemPanel();

        pack();
    }

    void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();


        // File menu
        //==================================================================
        JMenu fileMenu = new JMenu("File");

        JMenuItem helpMI = new JMenuItem("Help");
        helpMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.showHelp();
            }
        });
        fileMenu.add(helpMI);

        JMenuItem closeMI = new JMenuItem("Close");
        closeMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.close();
            }
        });
        fileMenu.add(closeMI);

        menuBar.add(fileMenu);


        // Home menu
        //==================================================================
        JMenu homeMenu = new JMenu("Home");

        // Clipboard submenu
        //==================================
        JMenu clipboardSubMenu = new JMenu("Clipboard");

        JMenuItem copyMI = new JMenuItem("Copy");
        copyMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        clipboardSubMenu.add(copyMI);

        JMenuItem pasteMI = new JMenuItem("Paste");
        pasteMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        clipboardSubMenu.add(pasteMI);

        JMenuItem cutMI = new JMenuItem("Cut");
        cutMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        clipboardSubMenu.add(cutMI);

        JMenuItem copyPathMI = new JMenuItem("Copy path");
        copyPathMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        clipboardSubMenu.add(copyPathMI);

        homeMenu.add(clipboardSubMenu);

        // Organize menu
        //==================================
        JMenu organizeSubMenu = new JMenu("Organize");

        JMenuItem moveToMI = new JMenuItem("Move to");
        moveToMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        organizeSubMenu.add(moveToMI);

        JMenuItem copyToMI = new JMenuItem("Copy to");
        copyToMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        organizeSubMenu.add(copyToMI);

        JMenuItem deleteMI = new JMenuItem("Delete");
        deleteMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        organizeSubMenu.add(deleteMI);

        JMenuItem renameMI = new JMenuItem("Rename");
        renameMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        organizeSubMenu.add(renameMI);

        homeMenu.add(organizeSubMenu);

        // New menu
        //==================================
        JMenu newSubMenu = new JMenu("New");

        JMenuItem newFolderMI = new JMenuItem("New folder");
        newFolderMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        newSubMenu.add(newFolderMI);

        JMenuItem newItemMI = new JMenuItem("New item");
        newItemMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        newSubMenu.add(newItemMI);

        homeMenu.add(newSubMenu);

        // Open menu
        JMenu openSubMenu = new JMenu("Open");

        JMenuItem propertiesMI = new JMenuItem("Properties");
        propertiesMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        openSubMenu.add(propertiesMI);

        JMenuItem openMI = new JMenuItem("Open");
        openMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        openSubMenu.add(openMI);

        JMenuItem editMI = new JMenuItem("Edit");
        editMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        openSubMenu.add(editMI);

        JMenuItem historyMI = new JMenuItem("History");
        historyMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        openSubMenu.add(historyMI);

        homeMenu.add(openSubMenu);

        // Select menu
        //==================================
        JMenu selectSubMenu = new JMenu("Select");

        JMenuItem selectAllMI = new JMenuItem("Select all");
        selectAllMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        selectSubMenu.add(selectAllMI);

        JMenuItem selectNoneMI = new JMenuItem("Select none");
        selectNoneMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        selectSubMenu.add(selectNoneMI);

        JMenuItem selectInvertMI = new JMenuItem("Select invert");
        selectInvertMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        selectSubMenu.add(selectInvertMI);

        homeMenu.add(selectSubMenu);

        menuBar.add(homeMenu);


        // Share menu
        //==================================================================
        JMenu shareMenu = new JMenu("Share");

        // Send menu
        //==================================
        JMenu sendSubMenu = new JMenu("Send");

        JMenuItem zipMI = new JMenuItem("Zip");
        zipMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sendSubMenu.add(zipMI);

        shareMenu.add(sendSubMenu);

        menuBar.add(shareMenu);

        // View menu
        //==================================================================
        JMenu viewMenu = new JMenu("View");

        // Panes menu
        //==================================
        JMenu panesSubMenu = new JMenu("Panes");

        JMenuItem navigationPaneMI = new JMenuItem("Navigation pane");
        navigationPaneMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panesSubMenu.add(navigationPaneMI);

        JMenuItem previewPaneMI = new JMenuItem("Preview pane");
        previewPaneMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panesSubMenu.add(previewPaneMI);

        JMenuItem detailsPaneMI = new JMenuItem("Details pane");
        detailsPaneMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panesSubMenu.add(detailsPaneMI);

        viewMenu.add(panesSubMenu);

        // Current view menu
        //==================================
        JMenu currentViewSubMenu = new JMenu("Current view");

        // Sort by menu
        //==================
        JMenu sortBySubMenu = new JMenu("Sort by");

        JMenuItem sortByNameMI = new JMenuItem("Name");
        sortByNameMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sortBySubMenu.add(sortByNameMI);

        JMenuItem sortByDateModifiedMI = new JMenuItem("Date modified");
        sortByDateModifiedMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sortBySubMenu.add(sortByDateModifiedMI);

        JMenuItem sortByTypeMI = new JMenuItem("Type");
        sortByTypeMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sortBySubMenu.add(sortByTypeMI);

        JMenuItem sortByDateCreatedMI = new JMenuItem("Date created");
        sortByDateCreatedMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        sortBySubMenu.add(sortByDateCreatedMI);

        currentViewSubMenu.add(sortBySubMenu);

        // Group by menu
        //==================
        JMenu groupBySubMenu = new JMenu("Group by");

        JMenuItem groupByNameMI = new JMenuItem("Name");
        groupByNameMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        groupBySubMenu.add(groupByNameMI);

        JMenuItem groupByDateModifiedMI = new JMenuItem("Date modified");
        groupByDateModifiedMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        groupBySubMenu.add(groupByDateModifiedMI);

        JMenuItem groupByTypeMI = new JMenuItem("Type");
        groupByTypeMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        groupBySubMenu.add(groupByTypeMI);

        JMenuItem groupBySizeMI = new JMenuItem("Size");
        groupBySizeMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        groupBySubMenu.add(groupBySizeMI);

        JMenuItem groupByDateCreatedMI = new JMenuItem("Date created");
        groupByDateCreatedMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        groupBySubMenu.add(groupByDateCreatedMI);

        currentViewSubMenu.add(groupBySubMenu);

        viewMenu.add(currentViewSubMenu);

        // Show/hide menu
        //==================================
        JMenu showHideSubMenu = new JMenu("Show/Hide");

        JCheckBoxMenuItem itemCheckBoxMI = new JCheckBoxMenuItem("Item check boxes");
        itemCheckBoxMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        showHideSubMenu.add(itemCheckBoxMI);

        JCheckBoxMenuItem fileNameExtensionMI = new JCheckBoxMenuItem("Item check boxes");
        fileNameExtensionMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        showHideSubMenu.add(fileNameExtensionMI);

        JCheckBoxMenuItem hiddenItemMI = new JCheckBoxMenuItem("Item check boxes");
        hiddenItemMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        showHideSubMenu.add(hiddenItemMI);

        JMenuItem hideSelectedItemsMI = new JMenuItem("Hide selected items");
        hideSelectedItemsMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        showHideSubMenu.add(hideSelectedItemsMI);

        viewMenu.add(showHideSubMenu);

        menuBar.add(viewMenu);


        // Setup Menubar
        setJMenuBar(menuBar);

    }

    void initAddressBar() {

        addressBar = new AddressBarUI();

        add(addressBar, BorderLayout.NORTH);

    }

    void initListItem() {

        listItem = new ListItemUI();
        listItem.setPreferredSize(new Dimension(200, 500));

        add(listItem, BorderLayout.WEST);

    }

    void initItemPanel() {

        itemPanel = new ItemPanelUI();

        add(itemPanel, BorderLayout.CENTER);

    }

}
