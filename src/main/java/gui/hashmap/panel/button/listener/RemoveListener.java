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
    private final HashMapPanel hashMapPanel;
    private final ImageProducer imageProducer;

    public RemoveListener(JTextField keyTextField, Map<Integer, Integer> map, HashMapPanel hashMapPanel, ImageProducer imageProducer) {
        this.keyTextField = keyTextField;
        this.map = map;
        this.hashMapPanel = hashMapPanel;
        this.imageProducer = imageProducer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer key = Integer.getInteger(keyTextField.getText());
        map.remove(key);
        hashMapPanel.setImage(imageProducer.produce(map));
    }
}
