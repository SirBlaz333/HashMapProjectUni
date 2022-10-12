package gui.hashmap.panel.image.text;

import java.awt.*;

public class TextDrawerImpl implements TextDrawer {
    private final int fontSize;
    private Color color;

    public TextDrawerImpl(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public void draw(Graphics graphics, int x, int y, int number) {
        String text = Integer.toString(number);
        if (text.length() > 7) {
            text = text.substring(0, 7);
            text = text.concat("...");
        }
        graphics.setColor(this.color);
        Font font = new Font("Arial", Font.BOLD, fontSize);
        graphics.setFont(font);
        graphics.drawString(text, x, y);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
