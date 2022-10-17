package gui.hashmap.panel.formatter;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;

public class IntegerFormatter extends NumberFormatter {

    public IntegerFormatter(NumberFormat numberFormat){
        super(numberFormat);
        setValueClass(Integer.class);
        setMinimum(Integer.MIN_VALUE);
        setMaximum(Integer.MAX_VALUE);
    }

    @Override
    public Object stringToValue(String text) throws ParseException {
        if(text.isBlank()){
            return null;
        }
        return super.stringToValue(text);
    }
}
