package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SizeListener implements ActionListener {
    private final JTextField valueTextField;
    private final Map<Integer, Integer> map;

    public SizeListener(JTextField valueTextField, Map<Integer, Integer> map) {
        this.valueTextField = valueTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer value = map.size();
        valueTextField.setText(value.toString());
    }
}
