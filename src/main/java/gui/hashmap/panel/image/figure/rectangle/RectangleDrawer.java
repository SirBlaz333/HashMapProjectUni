package gui.hashmap.panel.image.figure.rectangle;

import gui.hashmap.panel.image.Colorable;
import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

public class RectangleDrawer implements Figure{
    private final int side;
    private Color color;

    public RectangleDrawer(int side, Color color) {
        this.side = side;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics, int x, int y){
        graphics.setColor(color);
        graphics.drawRect(x, y, side, side);
    }

}
