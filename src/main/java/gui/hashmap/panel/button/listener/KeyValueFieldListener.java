package gui.hashmap.panel.button.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyValueFieldListener implements ActionListener {

    private final JTextField keyTextField;
    private final JTextField valueTextField;

    public KeyValueFieldListener(JTextField keyTextField, JTextField valueTextField) {
        this.keyTextField = keyTextField;
        this.valueTextField = valueTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String key = keyTextField.getText();
        String value = valueTextField.getText();
        if (key.isBlank() || value.isBlank()) {
            JOptionPane.showMessageDialog(null, "Enter the key and the value", "Error!!!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
