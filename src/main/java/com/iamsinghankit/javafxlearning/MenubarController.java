package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;

/**
 * @author Ankit Singh
 */
public class MenubarController {
    public void newMethod(ActionEvent event) {
        System.out.println("Selected: " + event.getEventType().getName());
    }
}
