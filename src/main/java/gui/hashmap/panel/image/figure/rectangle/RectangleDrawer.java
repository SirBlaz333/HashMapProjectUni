package gui.hashmap.panel.image.figure.rectangle;

import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

/**
 * Клас для прямокутника.
 */
public class RectangleDrawer implements Figure{
    private final int side;
    private Color color;

    /**
     * @param side сторона прямокутника
     * @param color колір прямокутника
     */
    public RectangleDrawer(int side, Color color) {
        this.side = side;
        this.color = color;
    }

    /**
     * Функція для малювання прямокутника.
     * @param graphics графічний об'єкт
     * @param x координата x лівого верхнього кута прямокутника
     * @param y координата у лівого верхнього кута прямокутника
     */

    @Override
        public void draw(Graphics graphics, int x, int y){
        graphics.setColor(color);
        graphics.drawRect(x, y, side, side);
    }

}
