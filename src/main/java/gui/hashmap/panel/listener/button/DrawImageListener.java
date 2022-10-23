package gui.hashmap.panel.listener.button;

import gui.hashmap.panel.HashMapPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class DrawImageListener implements ActionListener {
    private final HashMapPanel hashMapPanel;
    private final Map<Integer, Integer> map;

    public DrawImageListener(HashMapPanel hashMapPanel, Map<Integer, Integer> map) {
        this.hashMapPanel = hashMapPanel;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hashMapPanel.drawImage(map);
    }
}
