package FileExplorer.GUI;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HintTextField extends JTextField implements FocusListener {

    String hint;
    boolean showHint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;
        this.showHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        if (this.getText().isEmpty()) {
            super.setText("");
            showHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (this.getText().isEmpty()) {
            super.setText(hint);
            showHint = true;
        }
    }

    @Override
    public String getText() {
        return showHint ? "" : super.getText();
    }
}
