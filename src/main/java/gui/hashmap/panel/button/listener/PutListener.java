package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PutListener implements ActionListener {
    private final JTextField keyTextField;
    private final JTextField valueTextField;
    private final Map<Integer, Integer> map;
    private final HashMapPanel hashMapPanel;
    private final ImageProducer imageProducer;

    public PutListener(JTextField keyTextField, JTextField valueTextField, Map<Integer, Integer> map, HashMapPanel hashMapPanel, ImageProducer imageProducer) {
        this.keyTextField = keyTextField;
        this.valueTextField = valueTextField;
        this.map = map;
        this.hashMapPanel = hashMapPanel;
        this.imageProducer = imageProducer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer key = Integer.getInteger(keyTextField.getText());
        Integer value = Integer.getInteger(valueTextField.getText());
        map.put(key, value);
        hashMapPanel.setImage(imageProducer.produce(map));
    }
}
