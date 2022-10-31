package gui.hashmap.panel.listener.button;

import gui.hashmap.panel.listener.button.error.ParsingExceptionMessageDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class GetListener implements ActionListener {
    private final JTextField keyTextField;
    private final Map<Integer, Integer> map;

    public GetListener(JTextField keyTextField, Map<Integer, Integer> map) {
        this.keyTextField = keyTextField;
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            // отримуємо ключ
            Integer key = Integer.parseInt(keyTextField.getText());

            // якщо значення із заданим ключем міститься в hashmap
            if (map.containsKey(key)) {
                // отримуємо значення із hashamp
                Integer value = map.get(key);

                // виводимо відповідне повідомлення із отриманим значенням
                JOptionPane.showMessageDialog(null, "HashMap contains: " + value +
                        " at the key: " + key, "Get info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // якщо значення із заданим ключем не міститься в hashmap то виводимо відповідне повідомлення із отриманим значенням
                JOptionPane.showMessageDialog(null, "There is no value for the key: " + key,
                        "Get info", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException exception){
            // якщо введені дані в текстові поля некоректні
            ParsingExceptionMessageDialog.print();
        }
    }
}
