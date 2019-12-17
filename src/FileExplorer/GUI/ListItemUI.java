package FileExplorer.GUI;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.io.File;

public class ListItemUI extends JPanel implements TreeSelectionListener {
    JTree tree;

    ListItemUI(File[] items) {
        super(new GridLayout(1, 0));

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(items);
        //createNodes(top);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(this);
        JScrollPane treeView = new JScrollPane(tree);

        add(treeView);
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {

    }
}
