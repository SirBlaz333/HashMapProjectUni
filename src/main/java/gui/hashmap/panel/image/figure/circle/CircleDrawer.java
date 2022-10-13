package gui.hashmap.panel.image.figure.circle;

import gui.hashmap.panel.image.Colorable;
import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

public class CircleDrawer implements Figure, Colorable {
    private int radius;
    private Color color;

    public CircleDrawer(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics, int x, int y){

        graphics.setColor(color);
        graphics.drawOval(x, y, radius, radius);
    }

    @Override
    public void setColor(Color color){
        this.color = color;
    }

}
