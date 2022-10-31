package gui.hashmap.panel;

import gui.hashmap.panel.image.ImageProducer;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class HashMapPanel extends JPanel {
    private final JLabel imageLabel;
    private final ImageProducer imageProducer;
    public HashMapPanel(LayoutManager layoutManager) {
        super(layoutManager);
        //додаємо об'єкт, що буде відображати зображення
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(imageLabel, BorderLayout.CENTER);
        //створюємо об'єкт, що буде малювати зображення
        imageProducer = new ImageProducer(100);
    }

    /**
     * Малює зображення мапи на панелі
     * @param map мапа чисел
     */
    public void drawImage(Map<Integer, Integer> map){
        Image image = imageProducer.produce(map);
        imageLabel.setIcon(new ImageIcon(image));
    }
}
