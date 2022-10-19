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

    private final int TOP_BUTTON_ROW = 2;
    private final int BUTTON_COLUMN = 0;
    private final int BUTTON_GRID_WIDTH = 2;
    private final int BUTTON_GRID_HEIGHT = 1;

    private final int ELEMENT_WEIGHTX = 0;
    private final int ELEMENT_WEIGHTY = 0;
    private final int ELEMENT_PADX = 0;
    private final int ELEMENT_PADY = 0;

    private final int LABEL_COLUMN = 0;
    private final int TOP_LABEL_ROW = 0;
    private final int LABEL_GRID_WIDTH = 1;
    private final int LABEL_GRID_HEIGHT = 1;

    private final int TEXTFIELD_COLUMN = 1;
    private final int TOP_TEXTFIELD_ROW = 0;
    private final int TEXTFIELD_GRID_WIDTH = 1;
    private final int TEXTFIELD_GRID_HEIGHT = 1;
    private final int TEXTFIELD_WEIGHTX = 1;
    private final int TEXTFIELD_WEIGHTY = 0;
    private final Insets OBJECT_INSETS = new Insets(5, 5, 5, 5);



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

        /*putButton.setBackground(Color.GREEN);
        getButton.setBackground(Color.GREEN);
        removeButton.setBackground(Color.RED);
        clearButton.setBackground(Color.RED);
        sizeButton.setBackground(Color.BLUE);*/

        keyTextField.setPreferredSize(new Dimension(70, 20));
        valueTextField.setPreferredSize(new Dimension(70, 20));

        JLabel keyLabel = new JLabel("Key");
        JLabel valueLabel = new JLabel("Value");

        keyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

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



        GridBagLayout panelLayout = new GridBagLayout();

        GridBagConstraints keyLabelCons = new GridBagConstraints(
                LABEL_COLUMN,
                TOP_LABEL_ROW,
                LABEL_GRID_WIDTH,
                LABEL_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints valueLabelCons = new GridBagConstraints(
                LABEL_COLUMN,
                TOP_LABEL_ROW + 1,
                LABEL_GRID_WIDTH,
                LABEL_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.EAST,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints keyTextFieldCons = new GridBagConstraints(
                TEXTFIELD_COLUMN,
                TOP_TEXTFIELD_ROW,
                TEXTFIELD_GRID_WIDTH,
                TEXTFIELD_GRID_HEIGHT,
                TEXTFIELD_WEIGHTX,
                TEXTFIELD_WEIGHTY,
                GridBagConstraints.WEST,
                GridBagConstraints.VERTICAL,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints valueTextFieldCons = new GridBagConstraints(
                TEXTFIELD_COLUMN,
                TOP_TEXTFIELD_ROW + 1,
                TEXTFIELD_GRID_WIDTH,
                TEXTFIELD_GRID_HEIGHT,
                TEXTFIELD_WEIGHTX,
                TEXTFIELD_WEIGHTY,
                GridBagConstraints.WEST,
                GridBagConstraints.VERTICAL,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints putButtonCons = new GridBagConstraints(
                BUTTON_COLUMN,
                TOP_BUTTON_ROW,
                BUTTON_GRID_WIDTH,
                BUTTON_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );


        GridBagConstraints getButtonCons = new GridBagConstraints(
                BUTTON_COLUMN,
                TOP_BUTTON_ROW + 1,
                BUTTON_GRID_WIDTH,
                BUTTON_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints removeButtonCons = new GridBagConstraints(
                BUTTON_COLUMN,
                TOP_BUTTON_ROW + 2,
                BUTTON_GRID_WIDTH,
                BUTTON_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        GridBagConstraints clearButtonCons = new GridBagConstraints(
                BUTTON_COLUMN,
                TOP_BUTTON_ROW + 3,
                BUTTON_GRID_WIDTH,
                BUTTON_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );
        GridBagConstraints sizeButtonCons = new GridBagConstraints(
                BUTTON_COLUMN,
                TOP_BUTTON_ROW + 4,
                BUTTON_GRID_WIDTH,
                BUTTON_GRID_HEIGHT,
                ELEMENT_WEIGHTX,
                ELEMENT_WEIGHTY,
                GridBagConstraints.CENTER,
                GridBagConstraints.BOTH,
                OBJECT_INSETS,
                ELEMENT_PADX,
                ELEMENT_PADY
        );

        panelLayout.setConstraints(keyLabel, keyLabelCons);
        panelLayout.setConstraints(putButton, putButtonCons);
        panelLayout.setConstraints(keyTextField, keyTextFieldCons);
        panelLayout.setConstraints(getButton, getButtonCons);
        panelLayout.setConstraints(valueLabel, valueLabelCons);
        panelLayout.setConstraints(valueTextField, valueTextFieldCons);
        panelLayout.setConstraints(removeButton, removeButtonCons);
        panelLayout.setConstraints(clearButton, clearButtonCons);
        panelLayout.setConstraints(sizeButton, sizeButtonCons);


        add(keyLabel);
        add(putButton);
        add(keyTextField);
        add(getButton);
        add(valueLabel);
        add(valueTextField);
        add(removeButton);
        add(clearButton);
        add(sizeButton);

        setLayout(panelLayout);
    }

    private NumberFormatter createNumberFormatter(){
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setGroupingUsed(false);
        return new IntegerFormatter(numberFormat);
    }
}
