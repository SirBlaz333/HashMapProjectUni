package gui.hashmap.panel.image.text;

import java.awt.*;
import java.util.Map;

/**
 * Інтерфейс, що передбачає малювання текст
 */
public interface TextDrawer{
    /**
     * Метод, що реалізує малювання числа
     * @param graphics графічний об'єкт
     * @param x координата х
     * @param y координата y
     * @param key число
     */
    void draw(Graphics graphics, int x, int y, Map.Entry<Integer, Integer> entry);
}
