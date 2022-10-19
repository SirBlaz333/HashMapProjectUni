package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SizeListener implements ActionListener {
    private final Map<Integer, Integer> map;

    public SizeListener(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer value = map.size();
        JOptionPane.showMessageDialog(null, "Size of hash map is " + value, "Size", JOptionPane.INFORMATION_MESSAGE);
    }
}
