package gui.hashmap.panel.listener.button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class GetListener implements ActionListener {
    private final JTextField keyTextField;
    private final Map<Integer, Integer> map;

    public GetListener(JTextField keyTextField, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer key = Integer.parseInt(keyTextField.getText());

        if (map.containsKey(key)) {
            Integer value = map.get(key);
            JOptionPane.showMessageDialog(null, "HashMap contains: " + value +
                    " at the key: " + key, "Get info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "There is no value for the key: " + key,
                    "Get info", JOptionPane.ERROR_MESSAGE);
        }
    }
}
