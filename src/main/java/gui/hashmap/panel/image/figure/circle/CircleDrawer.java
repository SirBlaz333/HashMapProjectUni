package gui.hashmap.panel.image.figure.circle;

import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

public class CircleDrawer implements Figure {
    private int radius;
    private Color color;

    public CircleDrawer(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics, int x, int y){

        graphics.setColor(color);
        graphics.drawOval(x, y, radius, radius);
    }

}
