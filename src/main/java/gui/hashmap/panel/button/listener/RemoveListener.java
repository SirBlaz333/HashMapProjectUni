package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RemoveListener implements ActionListener {
    private final JTextField keyTextField;
    private final Map<Integer, Integer> map;

    public RemoveListener(JTextField keyTextField, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer key = Integer.parseInt(keyTextField.getText());
        map.remove(key);
    }
}
