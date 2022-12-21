package gui.hashmap.panel.image.text;

import java.awt.*;
import java.awt.font.TextLayout;
import java.util.Map;

/**
 * Клас для тексту
 */
public class TextDrawerImpl implements TextDrawer {
    private static final int NUMBER_LENGTH = 5;
    private final int fontSize;
    private final int height;
    private final int width;
    private final Color color;

    /**
     * Конструктор
     *
     * @param fontSize розмір шрифта
     * @param height   висота об'єкта в якому буде намальовани текст
     * @param width    ширина об'єкта в якому буде намальовани текст
     * @param color    колір
     */
    public TextDrawerImpl(int fontSize, int height, int width, Color color) {
        this.fontSize = fontSize;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics, int x, int y, Map.Entry<Integer, Integer> entry) {
        String textKey = reduceString(Integer.toString(entry.getKey()));
        String textValue = reduceString(Integer.toString(entry.getValue()));

        graphics.setColor(this.color);
        Font font = new Font("Arial", Font.BOLD, fontSize);
        graphics.setFont(font);
        drawTextInCenter(textKey, textValue, graphics, x, y);
    }

    private String reduceString(String string) {
        if (string.length() > NUMBER_LENGTH) {
            string = string.substring(0, NUMBER_LENGTH);
            string = string.concat("...");
        }
        return string;
    }

    //Метод, що малює число
    private void drawTextInCenter(String key, String value, Graphics graphics, int x, int y) {
        drawText(key, graphics, x, y);
        drawText(value, graphics, x, y + height / 3);
    }

    private void drawText(String text, Graphics graphics, int x, int y) {
        TextLayout textLayout = new TextLayout(text, graphics.getFont(), graphics.getFontMetrics().getFontRenderContext());
        double textHeight = textLayout.getBounds().getHeight();
        double textWidth = textLayout.getBounds().getWidth();
        int textX = width / 2 - (int) textWidth / 2;
        int textY = height / 3 + (int) textHeight / 2;
        graphics.drawString(text, textX + x, textY + y);
    }
}
