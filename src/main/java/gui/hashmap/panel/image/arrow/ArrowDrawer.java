package gui.hashmap.panel.image.arrow;

import java.awt.*;

public class ArrowDrawer {
    private int width;
    private int height;
    private Color color;

    public ArrowDrawer(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

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
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void fill(Graphics graphics, int x, int y) {
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
        graphics.fillPolygon(polygon);
    }
}
