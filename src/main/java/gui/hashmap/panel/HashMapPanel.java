package gui.hashmap.panel;

import gui.hashmap.MapRectangle;

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
        Graphics graphics = image.getGraphics();
        MapRectangle mapRectangle = new MapRectangle();
        mapRectangle.draw(graphics, 100, 100);

        MapRectangle mapRectangle1 = new MapRectangle(200, Color.CYAN, true);
        mapRectangle1.draw(graphics, 300, 230);
    }
}
