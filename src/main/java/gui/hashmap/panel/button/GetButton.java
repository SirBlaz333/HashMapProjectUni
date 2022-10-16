package gui.hashmap.panel.button;

import gui.hashmap.panel.button.listener.GetListener;

import javax.swing.*;
import java.util.Map;

public class GetButton extends JButton {
    private static final String TEXT = "Get";

    public GetButton(JTextField keyTextField, JTextField valueTextField, Map<Integer, Integer> map){
        addActionListener(new GetListener(keyTextField, valueTextField, map));
        setText(TEXT);
    }
}
