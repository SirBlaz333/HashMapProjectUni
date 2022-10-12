package gui.hashmap.panel;

import javax.swing.*;
import java.awt.*;

public class HashMapPanel extends GUIPanel {
    private ImageIcon imageIcon;
    public HashMapPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    @Override
    protected void init() {
        imageIcon = new ImageIcon();
        JLabel label = new JLabel(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
    }

    public void setImage(Image image){
        imageIcon.setImage(image);
    }
}
