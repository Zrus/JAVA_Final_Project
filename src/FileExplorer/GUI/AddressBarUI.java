package FileExplorer.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class AddressBarUI extends JPanel {

    AddressBarUI() {
        setLayout(new BorderLayout());

        initDirectionalButton();
        initAddressBar();
        initSearchBar();

    }

    void initDirectionalButton() {
        JPanel btnPanel = new JPanel();

        JButton backBtn = new JButton("<");
        backBtn.setPreferredSize(new Dimension(20, 20));
        backBtn.setBorder(BorderFactory.createEmptyBorder());
        btnPanel.add(backBtn);

        JButton forwardBtn = new JButton(">");
        forwardBtn.setPreferredSize(new Dimension(20, 20));
        forwardBtn.setBorder(BorderFactory.createEmptyBorder());
        btnPanel.add(forwardBtn);

        add(btnPanel, BorderLayout.WEST);
    }

    void initAddressBar() {
        JTextField addressBar = new JTextField();
        ArrayList<String> historyList = new ArrayList<>();
        setAutoComplete(addressBar, historyList);
        add(addressBar, BorderLayout.CENTER);
    }

    boolean isAdjusting(JComboBox inputCb) {
        if (inputCb.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) inputCb.getClientProperty("is_adjusting");
        }
        return false;
    }

    void setAdjusting(JComboBox inputCb, boolean adjusting) {
        inputCb.putClientProperty("is_adjusting", adjusting);
    }

    void setAutoComplete(JTextField textField, ArrayList<String> list) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox inputCb = new JComboBox(model);
        inputCb.setPreferredSize(new Dimension(this.getPreferredSize().width, 0));
        setAdjusting(inputCb, false);

        for (var item : list) {
            model.addElement(item);
        }

        inputCb.setSelectedItem(null);
        inputCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!isAdjusting(inputCb)) {
                    if (inputCb.getSelectedItem() != null) {
                        textField.setText(inputCb.getSelectedItem().toString());
                    }
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                setAdjusting(inputCb, true);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (inputCb.isPopupVisible()) {
                        e.setKeyCode(KeyEvent.VK_ENTER);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(inputCb);
                    inputCb.dispatchEvent(e);
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        textField.setText(inputCb.getSelectedItem().toString());
                        inputCb.setPopupVisible(false);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    inputCb.setPopupVisible(false);
                }
                setAdjusting(inputCb, false);
            }
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                updateList();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                updateList();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                updateList();
            }

            private void updateList() {
                setAdjusting(inputCb, true);
                model.removeAllElements();
                String input = textField.getText();
                if (!input.isEmpty()) {
                    for (var item : list) {
                        if (item.toLowerCase().startsWith(input.toLowerCase())) {
                            model.addElement(item);
                        }
                    }
                }
                inputCb.setPopupVisible(model.getSize() > 0);
                setAdjusting(inputCb, false);
            }
        });

        textField.setLayout(new BorderLayout());
        textField.add(inputCb, BorderLayout.SOUTH);
    }

    void initSearchBar() {
        JTextField searchField = new HintTextField("Search");
        searchField.setPreferredSize(new Dimension(200, 0));
        add(searchField, BorderLayout.EAST);
    }

}
