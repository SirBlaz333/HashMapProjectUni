package gui.hashmap.panel;

import gui.hashmap.panel.button.listener.ClearListener;
import gui.hashmap.panel.button.listener.DrawImageListener;
import gui.hashmap.panel.button.listener.GetListener;
import gui.hashmap.panel.button.listener.PutListener;
import gui.hashmap.panel.button.listener.RemoveListener;
import gui.hashmap.panel.button.listener.SizeListener;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class ControlPanel extends GUIPanel {
    private final HashMapPanel hashMapPanel;
    private final Map<Integer, Integer> map;
    public ControlPanel(LayoutManager layoutManager, HashMapPanel hashMapPanel) {
        super(layoutManager);
        this.hashMapPanel = hashMapPanel;
        this.map = new HashMap<>();
        initLayout();
    }

    @Override
    protected void init() {
    }

    private void initLayout(){
        setSize(200, 1000);
        NumberFormatter numberFormatter = createNumberFormatter();
        JFormattedTextField keyTextField = new JFormattedTextField(numberFormatter);
        JFormattedTextField valueTextField = new JFormattedTextField(numberFormatter);

        DrawImageListener drawImageListener = new DrawImageListener(hashMapPanel, map);
        PutListener putListener = new PutListener(keyTextField, valueTextField, map);
        GetListener getListener = new GetListener(keyTextField, valueTextField, map);
        RemoveListener removeListener = new RemoveListener(keyTextField, map);
        ClearListener clearListener = new ClearListener(map);
        SizeListener sizeListener = new SizeListener(valueTextField, map);

        JButton putButton = new JButton("Put");
        JButton getButton = new JButton("Get");
        JButton removeButton = new JButton("Remove");
        JButton clearButton = new JButton("Clear");
        JButton sizeButton = new JButton("Size");

        putButton.addActionListener(drawImageListener);
        putButton.addActionListener(putListener);
        removeButton.addActionListener(drawImageListener);
        removeButton.addActionListener(removeListener);
        clearButton.addActionListener(drawImageListener);
        clearButton.addActionListener(clearListener);
        getButton.addActionListener(getListener);
        sizeButton.addActionListener(sizeListener);

        keyTextField.setBounds(100, 100, 100 ,100);
        valueTextField.setBounds(100, 200, 100 ,100);
        putButton.setBounds(100, 300, 100, 100);
        getButton.setBounds(100, 400, 100, 100);
        removeButton.setBounds(100, 500, 100, 100);
        clearButton.setBounds(100, 600, 100, 100);
        sizeButton.setBounds(100, 700, 100, 100);
        add(keyTextField);
        add(valueTextField);
        add(putButton);
        add(getButton);
        add(removeButton);
        add(clearButton);
        add(sizeButton);
    }

    private NumberFormatter createNumberFormatter(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMinimum(Integer.MIN_VALUE);
        numberFormatter.setMaximum(Integer.MAX_VALUE);
        return numberFormatter;
    }
}
