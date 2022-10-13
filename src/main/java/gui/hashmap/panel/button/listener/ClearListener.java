package gui.hashmap.panel.button.listener;


import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ClearListener implements ActionListener {

    private final Map<Integer, Integer> map;
    private final HashMapPanel hashMapPanel;
    private final ImageProducer imageProducer;

    public ClearListener(Map<Integer, Integer> map, HashMapPanel hashMapPanel, ImageProducer imageProducer) {
        this.map = map;
        this.hashMapPanel = hashMapPanel;
        this.imageProducer = imageProducer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map.clear();
        hashMapPanel.setImage(imageProducer.produce(map));
    }
}
