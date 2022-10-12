package gui.hashmap.panel.text;

import java.awt.*;

public class TextDrawerImpl implements TextDrawer {
    private final int fontSize;

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
        graphics.setColor(Color.white);
        Font font = new Font("Arial", Font.BOLD, fontSize);
        graphics.setFont(font);
        graphics.drawString(text, x, y);
    }
}
