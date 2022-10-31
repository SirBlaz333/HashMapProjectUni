package gui.hashmap.panel.listener.button.error;

import javax.swing.*;

public class ParsingExceptionMessageDialog {
    /**
     * Виводить вікно з помилкою
     */
    public static void print(){
        JOptionPane.showMessageDialog(null, "Enter only integers in input fields!",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
