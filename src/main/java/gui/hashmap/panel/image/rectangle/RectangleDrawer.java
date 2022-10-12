package gui.hashmap.panel.image.rectangle;

import java.awt.*;

public class RectangleDrawer {
    private int side = 100;
    private Color color = Color.blue;
    private boolean filling = false;

    public RectangleDrawer(){}

    public RectangleDrawer(int side, Color color, boolean filling) {
        this.side = side;
        this.color = color;
        this.filling = filling;
    }

    public void draw(Graphics graphics, int x, int y){
        graphics.setColor(color);
        graphics.drawRect(x, y, side, side);
        if(filling){
            graphics.fillRect(x, y, side, side);
        }
    }
}
