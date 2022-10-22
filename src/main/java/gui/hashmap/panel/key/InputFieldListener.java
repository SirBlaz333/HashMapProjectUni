package gui.hashmap.panel.key;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;
import java.util.List;

public class InputFieldListener implements java.awt.event.KeyListener {
    private final List<JTextField> textFields;
    private final List<JButton> buttonList;

    public InputFieldListener(List<JTextField> textFields, List<JButton> buttonList) {
        this.textFields = textFields;
        this.buttonList = buttonList;
        setButtonsEnabled(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        boolean isPressable = textFields.stream()
                .map(JTextComponent::getText)
                .reduce(true, (aBoolean, s) -> aBoolean && fieldIsCorrect(s), Boolean::logicalAnd);
        if(!isPressable){
            setButtonsEnabled(false);
            return;
        }
        setButtonsEnabled(true);
    }

    private void setButtonsEnabled(boolean value){
        for(JButton button : buttonList){
            button.setEnabled(value);
        }
    }

    private boolean fieldIsCorrect(String s){
        return textIsInteger(s) && !s.isBlank();
    }

    private boolean textIsInteger(String text){
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
