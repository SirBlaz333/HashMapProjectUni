package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class GetListener implements ActionListener {
    private final JTextField keyTextField;
    private final JTextField valueTextField;
    private final Map<Integer, Integer> map;

    public GetListener(JTextField keyTextField, JTextField valueTextField1, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.valueTextField = valueTextField1;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer key = Integer.parseInt(keyTextField.getText());
        Integer value = map.get(key);
        valueTextField.setText(value.toString());
    }
}
