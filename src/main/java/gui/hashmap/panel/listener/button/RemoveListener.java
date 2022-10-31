package gui.hashmap.panel.listener.button;

import gui.hashmap.panel.listener.button.error.ParsingExceptionMessageDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Клас реалізує подію натиснення кнопки Remove: видалення елементу з HashMap.
 */
public class RemoveListener implements ActionListener {
    private final JTextField keyTextField;
    private final Map<Integer, Integer> map;

    public RemoveListener(JTextField keyTextField, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Integer key = Integer.parseInt(keyTextField.getText());     //зчитування даних
            if (map.containsKey(key)) {
                map.remove(key);         // видалення елемента
            } else {    //виведення повідомлення про відсутність елемента з введеним ключем
                JOptionPane.showMessageDialog(null, "There is no value for the key: " + key,
                        "Remove error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception){
            ParsingExceptionMessageDialog.print(); //виведення повідомлення про помилку
        }
    }
}
