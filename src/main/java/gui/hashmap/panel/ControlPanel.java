package gui.hashmap.panel;

import gui.hashmap.panel.button.listener.ClearListener;
import gui.hashmap.panel.button.listener.DrawImageListener;
import gui.hashmap.panel.button.listener.GetListener;
import gui.hashmap.panel.button.listener.KeyFieldListener;
import gui.hashmap.panel.button.listener.KeyValueFieldListener;
import gui.hashmap.panel.button.listener.PutListener;
import gui.hashmap.panel.button.listener.RemoveListener;
import gui.hashmap.panel.button.listener.SizeListener;
import gui.hashmap.panel.formatter.IntegerFormatter;

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
        KeyFieldListener keyFieldListener = new KeyFieldListener(keyTextField);
        KeyValueFieldListener keyValueFieldListener = new KeyValueFieldListener(keyTextField, valueTextField);
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

        JLabel keyLabel = new JLabel("Key", Label.RIGHT);
        JLabel valueLabel = new JLabel("Value", Label.RIGHT);
        Font font = new Font("Serif", Font.BOLD, 18);
        keyLabel.setFont(font);
        valueLabel.setFont(font);

        putButton.addActionListener(drawImageListener);
        putButton.addActionListener(putListener);
        putButton.addActionListener(keyValueFieldListener);
        removeButton.addActionListener(drawImageListener);
        removeButton.addActionListener(removeListener);
        removeButton.addActionListener(keyFieldListener);
        clearButton.addActionListener(drawImageListener);
        clearButton.addActionListener(clearListener);
        getButton.addActionListener(getListener);
        getButton.addActionListener(keyFieldListener);
        sizeButton.addActionListener(sizeListener);



        GridBagLayout gb1 = new GridBagLayout();
        Insets panelInsets = new Insets(5, 5, 5, 5);

        GridBagConstraints keyLabelCons = new GridBagConstraints(
                0,
                0,
                1,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                100,
                0
        );

        GridBagConstraints valueLabelCons = new GridBagConstraints(
                0,
                1,
                1,
                1,
                0,
                0,
                GridBagConstraints.EAST,
                GridBagConstraints.BOTH,
                panelInsets,
                100,
                0
        );

        GridBagConstraints putButtonCons = new GridBagConstraints(
                0,
                2,
                2,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                panelInsets,
                0,
                0
        );

        GridBagConstraints keyTextFieldCons = new GridBagConstraints(
                1,
                0,
                1,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );

        GridBagConstraints valueTextFieldCons = new GridBagConstraints(
                1,
                1,
                1,
                1,
                1,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );
        GridBagConstraints getButtonCons = new GridBagConstraints(
                0,
                3,
                2,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );

        GridBagConstraints removeButtonCons = new GridBagConstraints(
                0,
                4,
                2,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );

        GridBagConstraints clearButtonCons = new GridBagConstraints(
                0,
                5,
                2,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );
        GridBagConstraints sizeButtonCons = new GridBagConstraints(
                0,
                6,
                2,
                1,
                0,
                0,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                panelInsets,
                0,
                0
        );

        gb1.setConstraints(keyLabel, keyLabelCons);
        gb1.setConstraints(putButton, putButtonCons);
        gb1.setConstraints(keyTextField, keyTextFieldCons);
        gb1.setConstraints(getButton, getButtonCons);
        gb1.setConstraints(valueLabel, valueLabelCons);
        gb1.setConstraints(valueTextField, valueTextFieldCons);
        gb1.setConstraints(removeButton, removeButtonCons);
        gb1.setConstraints(clearButton, clearButtonCons);
        gb1.setConstraints(sizeButton, sizeButtonCons);


        add(keyLabel);
        add(putButton);
        add(keyTextField);
        add(getButton);
        add(valueLabel);
        add(valueTextField);
        add(removeButton);
        add(clearButton);
        add(sizeButton);

        setLayout(gb1);
    }

    private NumberFormatter createNumberFormatter(){
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setGroupingUsed(false);
        return new IntegerFormatter(numberFormat);
    }
}
