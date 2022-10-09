package gui.hashmap.panel;

import javax.swing.*;
import java.awt.LayoutManager;

public abstract class GUIPanel extends JPanel {
    public GUIPanel(LayoutManager layoutManager) {
        super(layoutManager);
        init();
        initLayout();
    }

    protected abstract void init();

    private void initLayout(){
        this.setBorder(BorderFactory.createEtchedBorder());
    }
}
