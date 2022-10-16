package gui.hashmap.panel.button;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.button.listener.ClearListener;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.util.Map;

public class ClearButton extends JButton{
    private static final String TEXT = "Clear";

    public ClearButton(Map<Integer, Integer> map){
        addActionListener(new ClearListener(map);
        setText(TEXT);
    }
}
