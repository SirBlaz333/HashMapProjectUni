package gui.hashmap.panel.image.figure.arrow;

import gui.hashmap.panel.image.Colorable;
import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

public class ArrowDrawer implements Figure, Colorable {
    private final int width;
    private final int height;
    private Color color;

    public ArrowDrawer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        Polygon polygon = new Polygon(
                new int[]{
                        x + (int) (0.75 * width),
                        x + width,
                        x + width,
                        x + (int) (0.75 * width),
                        x + (int) (0.75 * width),
                        x,
                        x,
                        x + (int) (0.75 * width)
                },
                new int[]{
                        y,
                        y + (int) (0.5 * height),
                        y + (int) (0.5 * height),
                        y + height,
                        y + (int) (0.7 * height),
                        y + (int) (0.7 * height),
                        y + (int) (0.3 * height),
                        y + (int) (0.3 * height)
                },
                8);

        graphics.setColor(color);
        graphics.drawPolygon(polygon);
        graphics.fillPolygon(polygon);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
