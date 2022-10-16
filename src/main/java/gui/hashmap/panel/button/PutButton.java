package gui.hashmap.panel.button;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.button.listener.PutListener;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.util.Map;

public class PutButton extends JButton {
    private static final String TEXT = "Put";

    public PutButton(JTextField keyTextField, JTextField valueTextField, Map<Integer, Integer> map, HashMapPanel hashMapPanel, ImageProducer imageProducer){
        addActionListener(new PutListener(keyTextField, valueTextField, map, hashMapPanel, imageProducer));
        setText(TEXT);
    }
}
