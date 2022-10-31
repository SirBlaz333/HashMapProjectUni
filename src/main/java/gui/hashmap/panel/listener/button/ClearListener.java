package gui.hashmap.panel.listener.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Клас реалізує подію натиснення кнопки Clear: видаляє всі елементи з HashMap, після чого HashMap є пустою
 */

public class ClearListener implements ActionListener {
    private final Map<Integer, Integer> map;

    public ClearListener(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map.clear();
    }
}
