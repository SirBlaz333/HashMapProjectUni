package gui.hashmap.panel.listener.button;

import gui.hashmap.panel.listener.button.error.ParsingExceptionMessageDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PutListener implements ActionListener {
    private final JTextField keyTextField;
    private final JTextField valueTextField;
    private final Map<Integer, Integer> map;

    public PutListener(JTextField keyTextField, JTextField valueTextField, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.valueTextField = valueTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Integer key = Integer.parseInt(keyTextField.getText());
            Integer value = Integer.parseInt(valueTextField.getText());
            map.put(key, value);
        } catch (NumberFormatException exception){
            ParsingExceptionMessageDialog.print();
        }
    }
}
