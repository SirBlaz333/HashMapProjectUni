package gui.hashmap.panel.image.figure;

import java.awt.*;

/**
 * Інтерфейс, що передбачає малювання певної фігури за координатами
 */
public interface Figure {
    /**
     * Метод, що малює фігуру за координатами
     * @param graphics графічний об'єкт
     * @param x координата х
     * @param y координата y
     */
    void draw(Graphics graphics, int x, int y);
}
