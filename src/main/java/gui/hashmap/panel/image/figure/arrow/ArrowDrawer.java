package gui.hashmap.panel.image.figure.arrow;

import gui.hashmap.panel.image.figure.Figure;

import java.awt.*;

/**
 * ArrowDrawer для малювання стрілки на екрані
 */
public class ArrowDrawer implements Figure {
    // ширина стрілки
    private final int width;

    // висота стрілки
    private final int height;

    // колір фону стрілки
    private final Color color;

    /**
     * Конструктор
     * @param height висота стрілки
     * @param width ширина стрілки
     * @param color колір стрілки
     */
    public ArrowDrawer(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Метод, що реалізує малювання стрілки
     * @param graphics графічний об'єкт
     * @param x координата х лівої верхньої сторони
     * @param y координата y лівої верхньої сторони
     */
    @Override
    public void draw(Graphics graphics, int x, int y) {
        // створюємо полігон у формі стрілки із точок
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

        // встановлюємо колір
        graphics.setColor(color);

        // малюємо стрілку
        graphics.drawPolygon(polygon);
        graphics.fillPolygon(polygon);
    }
}
