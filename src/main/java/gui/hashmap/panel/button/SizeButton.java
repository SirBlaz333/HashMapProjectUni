package gui.hashmap.panel.button;

import gui.hashmap.panel.button.listener.SizeListener;

import javax.swing.*;
import java.util.Map;

public class SizeButton extends JButton {
    private static final String TEXT = "Size";

    public SizeButton(JTextField valueTextField, Map<Integer, Integer> map){
        addActionListener(new SizeListener(valueTextField, map));
        setText(TEXT);
    }
}
