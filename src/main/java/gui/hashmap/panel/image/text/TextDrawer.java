package gui.hashmap.panel.image.text;

import gui.hashmap.panel.image.Colorable;

import java.awt.*;

public interface TextDrawer extends Colorable {
    void draw(Graphics graphics, int x, int y, int number);
}
