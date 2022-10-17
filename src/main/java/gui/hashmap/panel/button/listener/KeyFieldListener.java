package gui.hashmap.panel.button.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyFieldListener implements ActionListener {
    private final JTextField keyTextField;

    public KeyFieldListener(JTextField keyTextField) {
        this.keyTextField = keyTextField;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String key = keyTextField.getText();
        if (key.isBlank()) {
            JOptionPane.showMessageDialog(null,"Enter the key" ,"Error!!!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
