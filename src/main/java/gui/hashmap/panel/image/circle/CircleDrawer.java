package gui.hashmap.panel.image.circle;

import java.awt.*;

public class CircleDrawer {
    private int radius;

    public CircleDrawer(){}

    public CircleDrawer(int radius) {
        this.radius = radius;
    }

    public void draw(Graphics graphics, int x, int y){
        graphics.drawOval(x, y, radius, radius);
    }
}
