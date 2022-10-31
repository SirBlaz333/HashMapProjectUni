package gui.hashmap.panel.image.text;

import java.awt.*;

/**
 * Інтерфейс, що передбачає малювання текст
 */
public interface TextDrawer{
    /**
     * Метод, що реалізує малювання числа
     * @param graphics графічний об'єкт
     * @param x координата х
     * @param y координата y
     * @param number число
     */
    void draw(Graphics graphics, int x, int y, int number);
}
