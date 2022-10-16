package gui.hashmap.panel.button.listener;


import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ClearListener implements ActionListener {

    private final Map<Integer, Integer> map;


    public ClearListener(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map.clear();
    }
}
