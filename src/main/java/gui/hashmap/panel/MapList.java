package gui.hashmap.panel;

import java.awt.*;

public class MapList {
    private int radius;

    public MapList(){}

    public MapList(int radius) {
        this.radius = radius;
    }

    public void draw(Graphics graphics, int x, int y){
        graphics.drawOval(x, y, radius, radius);
    }
}
