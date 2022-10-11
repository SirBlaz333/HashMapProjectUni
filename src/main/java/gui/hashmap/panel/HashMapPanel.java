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
        Graphics graphics = image.getGraphics();

        Arrow arrow1 = new Arrow(40, 20, Color.BLUE);
        arrow1.draw(graphics, 100, 150);
        arrow1.fill(graphics, 100, 150);

        Arrow arrow2 = new Arrow(60, 30, Color.RED);
        arrow2.draw(graphics, 100, 200);
        arrow2.fill(graphics, 100, 200);

        Arrow arrow3 = new Arrow(80, 40, Color.GREEN);
        arrow3.draw(graphics, 100, 250);
        arrow3.fill(graphics, 100, 250);
    }
}
