package gui.hashmap.panel.button.listener;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.util.Map;

public class SizeButton extends JButton {
    private static final String TEXT = "Size";

    public SizeButton(JTextField valueTextField, Map<Integer, Integer> map){
        addActionListener(new SizeListener(valueTextField, map));
        setText(TEXT);
    }
}
