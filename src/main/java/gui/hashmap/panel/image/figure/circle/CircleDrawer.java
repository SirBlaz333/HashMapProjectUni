package gui.hashmap.panel.image.figure.circle;

import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

/**
 * Клас коло.
 * Містить поля: radius - радіус кола, color - колір обводки кола.
 */

public class CircleDrawer implements Figure {
    private int radius;
    private Color color;

    public CircleDrawer(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    /**
     * Метод малювання кола
     * @param graphics графічний об'єкт
     * @param x координата х лівого верхнього кута кола
     * @param y координата у лівого верхнього кута кола
     */
    @Override
    public void draw(Graphics graphics, int x, int y){

        graphics.setColor(color);
        graphics.drawOval(x, y, radius, radius);
    }

}
