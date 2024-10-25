/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrdarip.T1E5PDF2;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author mrdarip
 */
class Input {
    String label;
    InputType type;
    private Control input;
    
    public Input(String label, InputType type) {
        this.label = label;
        this.type = type;
        
        switch (type) {
            case InputType.COLOR:
                input = new ColorPicker();
                break;
            
            case InputType.NUMBER:
                input = new TextField();
                break;
                
            default:
            case InputType.TEXT:
                input = new TextField();
                break;
        }
    }
    
    public HBox asBox(){
        return new HBox(
                new Label(label),
                input
        );
    }
    
    public Object getValue() {
        switch (type) {
            case COLOR:
                return ((ColorPicker) input).getValue(); 
                
            case NUMBER:
                try {
                    return Integer.parseInt(((TextField) input).getText());
                } catch (NumberFormatException e) {
                    return null;
                }
                
            case TEXT:
            default:
                return ((TextField) input).getText();
        }
    }
    
}
