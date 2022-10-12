package gui.hashmap.panel;

import java.awt.*;

public class MapList {
    private int radius;
    private int x, y;

    public MapList(){}

    public MapList(int radius, int x, int y) {
        this.radius = radius;
        this.y = y;
        this.x = x;
    }

    public void draw(Graphics graphics){
        graphics.drawOval(x, y, radius, radius);
    }
}
