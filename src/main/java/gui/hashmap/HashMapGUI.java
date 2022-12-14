package gui.hashmap;

import gui.hashmap.panel.ControlPanel;
import gui.hashmap.panel.HashMapPanel;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class HashMapGUI extends JFrame {
    private static final String TITLE = "HashMap GUI";
    private static final Integer HASHMAP_PANEL_COLUMN = 0;
    private static final Integer CONTROL_PANEL_COLUMN = 1;
    private static final Integer DEFAULT_INSET = 5;
    private static final Integer PANEL_ROW = 0;
    private static final Integer GRID_WIDTH = 1;
    private static final Integer GRID_HEIGHT = 1;
    private static final BigDecimal HASHMAP_PANEL_X_WEIGHT_MULTIPLIER = BigDecimal.valueOf(0.75);
    private static final BigDecimal CONTROL_PANEL_X_WEIGHT_MULTIPLIER = BigDecimal.valueOf(0.25);
    private static final BigDecimal PANELS_Y_MULTIPLIER = BigDecimal.valueOf(1.0);
    public static final Integer PAD_X = 0;
    public static final Integer PAD_Y = 0;
    public static final int GUI_WIDTH = 1000;
    public static final int GUI_HEIGHT = 600;
    private final HashMapPanel hashmapPanel;
    private final ControlPanel controlPanel;

    public HashMapGUI() throws HeadlessException {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ініціалізуємо поля
        hashmapPanel = new HashMapPanel(new GridLayout());
        controlPanel = new ControlPanel(new GridLayout(), hashmapPanel);
        initLayout();
    }

    //ініціалізація розмітки
    private void initLayout() {
        getContentPane().setLayout(new GridBagLayout());
        Insets panelInsets = new Insets(DEFAULT_INSET, DEFAULT_INSET, DEFAULT_INSET, DEFAULT_INSET);

        //задаємо обмеження для панелі з зображенням
        GridBagConstraints hashmapPanelGridBagConstraints = new GridBagConstraints(
                HASHMAP_PANEL_COLUMN,
                PANEL_ROW,
                GRID_WIDTH,
                GRID_HEIGHT,
                HASHMAP_PANEL_X_WEIGHT_MULTIPLIER.doubleValue(),
                PANELS_Y_MULTIPLIER.doubleValue(),
                GridBagConstraints.WEST,
                GridBagConstraints.BOTH,
                panelInsets,
                PAD_X,
                PAD_Y);

        //задаємо обмеження для панелі керування
        GridBagConstraints controlPanelGridBagConstraints = new GridBagConstraints(
                CONTROL_PANEL_COLUMN,
                PANEL_ROW,
                GRID_WIDTH,
                GRID_HEIGHT,
                CONTROL_PANEL_X_WEIGHT_MULTIPLIER.doubleValue(),
                PANELS_Y_MULTIPLIER.doubleValue(),
                GridBagConstraints.WEST,
                GridBagConstraints.BOTH,
                panelInsets,
                PAD_X,
                PAD_Y);

        //додавання смуг прокручування
        JScrollPane scrollableHashMapPanel = new JScrollPane(hashmapPanel);
        scrollableHashMapPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableHashMapPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        getContentPane().add(scrollableHashMapPanel, hashmapPanelGridBagConstraints);
        getContentPane().add(controlPanel, controlPanelGridBagConstraints);
        Dimension dimension = new Dimension(GUI_WIDTH, GUI_HEIGHT);
        setPreferredSize(dimension);
        pack();
    }
}
