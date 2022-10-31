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

/**
 * Клас, що слугує для створення зображення з мапи
 */
public class ImageProducer {
    private static final int DEFAULT_SIZE = 4;
    private static final double LOAD_FACTOR = 0.75;
    private static final int MULTIPLICATION = 2;
    public static final int FONT_SIZE = 20;
    public static final int MIN_SIZE = 1;
    private final RectangleDrawer rectangleDrawer;
    private final CircleDrawer circleDrawer;
    private final ArrowDrawer arrowDrawer;
    private final TextDrawer textDrawer;
    private final int blockSize;

    /**
     * @param blockSize розмір однієї ячейки з даними
     */
    public ImageProducer(int blockSize) {
        this.blockSize = blockSize;
        this.rectangleDrawer = new RectangleDrawer(blockSize, Color.BLACK);
        this.circleDrawer = new CircleDrawer(blockSize, Color.BLACK);
        this.arrowDrawer = new ArrowDrawer(blockSize, blockSize, Color.BLACK);
        this.textDrawer = new TextDrawerImpl(FONT_SIZE, blockSize, blockSize, Color.BLACK);
    }

    /**
     * Метод отримує мапу чисел та повертає намальоване зображення.
     * Зображення складається з вертикального ряду квадратів, кожен з яких
     * зображує ячейку масиву, яка зберігає зв'язний список даних. Зображення
     * в'язного списку складається з вузла, який відображає дані, що в ньому зберігаються
     * та стрілки, яка відображає посилання на наступний вузол.
     * @param map мапа, яку потрібно змалювати
     * @return зображення мапи
     */
    public Image produce(Map<Integer, Integer> map) {
        //вираховуємо розмір масиву(кількість вертикальних квадратів)
        int arraySize = calculateArraySize(map.keySet());
        //отримаємо мапу, що зберігає список даних, які лежать в певній комірці масиву
        //номер комірки масиву - це остача ділення хеш-значення ключа на розмір масиву
        Map<Integer, List<Integer>> remainderMap = toRemainderMap(map, arraySize);
        //отримаємо значення найдовшого масиву. Якщо такого значення немає, то отримаємо 0
        int longestListSize = remainderMap.values()
                .stream()
                .map(List::size)
                .max(Integer::compareTo)
                .orElse(MIN_SIZE);
        //вираховуємо ширину зображення
        int imageWidth = (longestListSize + 1) * blockSize * 2;
        //вираховуємо висоту зображення
        int imageHeight = (arraySize + 2) * blockSize;
        //створюємо порожнє зображення відповідної ширини та висоти
        BufferedImage bufferedImage = createImage(imageWidth, imageHeight);
        //малюємо мапу
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
            //вираховуємо значення хеш-коду ключа
            int hash = key.hashCode();
            //вираховуємо остачу від ділення хеш-коду ключа на розмір масиву
            int remainder = Math.floorMod(hash, arraySize);
            //отримаємо зв'язний список
            List<Integer> list = remainderMap.get(remainder);
            //якщо його немає то створюємо новий
            if (list == null) {
                list = new ArrayList<>();
            }
            //добавляємо значення до списку
            list.add(map.get(key));
            //добавляємо список до мапи залишків
            remainderMap.put(remainder, list);
        }
        return remainderMap;
    }

    private Integer calculateArraySize(Set<Integer> set) {
        //розмір за замовчуванням
        int size = DEFAULT_SIZE;
        //поки розмір масиву менший за розмір ключів, збільшити його на певне значення
        while (size * LOAD_FACTOR < set.size()) {
            size *= MULTIPLICATION;
        }
        return size;
    }

    private void drawMap(Graphics graphics, Map<Integer, List<Integer>> remainderMap, int arraySize) {
        int x = blockSize;
        int y = blockSize;
        for (int i = 0; i < arraySize; i++) {
            //малюємо квадрат за координатами
            rectangleDrawer.draw(graphics, x, y);
            //якщо є список який потрібно намалювати то малюємо.
            if (remainderMap.containsKey(i)) {
                drawList(graphics, remainderMap.get(i), x, y);
            }
            //переходимо до наступного квадрату
            y += blockSize;
        }
    }

    private void drawList(Graphics graphics, List<Integer> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            //отримаємо число що потрібно намалювати
            Integer integer = list.get(i);
            //малюємо число в крузі
            circleDrawer.draw(graphics, x, y);
            textDrawer.draw(graphics, x, y, integer);
            //переходимо до наступного елементу
            x += blockSize;
            //якщо це не останній елемент, то малюємо стрілку і збільшуємо ще раз х
            if(i < list.size() - 1){
                arrowDrawer.draw(graphics, x, y);
            }
            x += blockSize;
        }
    }
}
