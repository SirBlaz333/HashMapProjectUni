package gui.hashmap.panel.image.figure.rectangle;

import gui.hashmap.panel.image.Colorable;
import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

public class RectangleDrawer implements Figure, Colorable {
    private final int side;
    private Color color;

    public RectangleDrawer(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics graphics, int x, int y){
        graphics.setColor(color);
        graphics.drawRect(x, y, side, side);
    }
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
