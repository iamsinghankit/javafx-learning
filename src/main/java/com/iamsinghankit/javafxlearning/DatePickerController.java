package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Ankit Singh
 */
public class DatePickerController {
    public DatePicker myDatePicker;
    public Label myLabel;
    public void selectDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        String value = myDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        myLabel.setText(value);
    }
}
