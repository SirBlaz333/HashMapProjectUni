package gui.hashmap.panel.image;

import gui.hashmap.panel.image.figure.arrow.ArrowDrawer;
import gui.hashmap.panel.image.figure.circle.CircleDrawer;
import gui.hashmap.panel.image.figure.rectangle.RectangleDrawer;
import gui.hashmap.panel.image.text.TextDrawer;
import gui.hashmap.panel.image.text.TextDrawerImpl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImageProducer {
    private static final int DEFAULT_SIZE = 4;
    private static final double LOAD_FACTOR = 0.75;
    private static final int MULTIPLICATION = 2;
    public static final int FONT_SIZE = 20;
    public static final int MIN_SIZE = 0;
    private final RectangleDrawer rectangleDrawer;
    private final CircleDrawer circleDrawer;
    private final ArrowDrawer arrowDrawer;
    private final TextDrawer textDrawer;
    private final int blockSize;

    public ImageProducer(int blockSize) {
        this.blockSize = blockSize;
        this.rectangleDrawer = new RectangleDrawer(blockSize, Color.BLACK);
        this.circleDrawer = new CircleDrawer(blockSize, Color.BLACK);
        this.arrowDrawer = new ArrowDrawer(blockSize, blockSize, Color.BLACK);
        this.textDrawer = new TextDrawerImpl(FONT_SIZE, blockSize, blockSize, Color.BLACK);
    }

    public Image produce(Map<Integer, Integer> map) {
        int arraySize = calculateArraySize(map.keySet());
        Map<Integer, List<Integer>> remainderMap = toRemainderMap(map, arraySize);
        int longestListSize = remainderMap.values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(MIN_SIZE);
        int imageWidth = (longestListSize + 1) * blockSize * 2;
        int imageHeight = (arraySize + 2) * blockSize;
        if(map.isEmpty()){
            imageWidth += blockSize;
        }
        BufferedImage bufferedImage = createImage(imageWidth, imageHeight);
        drawMap(bufferedImage.getGraphics(), remainderMap, arraySize);
        return bufferedImage;
    }

    private BufferedImage createImage(int imageWidth, int imageHeight){
        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        return bufferedImage;
    }

    private Map<Integer, List<Integer>> toRemainderMap(Map<Integer, Integer> map, int arraySize) {
        Map<Integer, List<Integer>> remainderMap = new HashMap<>();
        for (Integer key : map.keySet()) {
            int remainder = key % arraySize;
            int objectToAdd = map.get(key);
            List<Integer> list = remainderMap.get(remainder);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(objectToAdd);
            remainderMap.put(remainder, list);
        }
        return remainderMap;
    }

    private Integer calculateArraySize(Set<Integer> set) {
        int size = DEFAULT_SIZE;
        while (size * LOAD_FACTOR < set.size()) {
            size *= MULTIPLICATION;
        }
        return size;
    }

    private void drawMap(Graphics graphics, Map<Integer, List<Integer>> remainderMap, int arraySize) {
        int x = blockSize;
        int y = blockSize;
        for (int i = 0; i < arraySize; i++) {
            rectangleDrawer.draw(graphics, x, y);
            if (remainderMap.containsKey(i)) {
                drawList(graphics, remainderMap.get(i), x, y);
            }
            y += blockSize;
        }
    }

    private void drawList(Graphics graphics, List<Integer> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            circleDrawer.draw(graphics, x, y);
            textDrawer.draw(graphics, x, y, integer);
            x += blockSize;
            if(i < list.size() - 1){
                arrowDrawer.draw(graphics, x, y);
            }
            x += blockSize;
        }
    }
}
