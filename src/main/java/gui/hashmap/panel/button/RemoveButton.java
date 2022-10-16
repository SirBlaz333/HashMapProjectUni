package gui.hashmap.panel.button;

import gui.hashmap.panel.HashMapPanel;
import gui.hashmap.panel.button.listener.RemoveListener;
import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.util.Map;

public class RemoveButton extends JButton{
    private static final String TEXT = "Remove";

    public RemoveButton(JTextField keyTextField, Map<Integer, Integer> map){
        addActionListener(new RemoveListener(keyTextField, map));
        setText(TEXT);
    }
}
