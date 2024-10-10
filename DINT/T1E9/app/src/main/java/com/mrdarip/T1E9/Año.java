/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrdarip.T1E9;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author mrdarip
 */
public class Año {
    private final SimpleStringProperty año;
    private final SimpleStringProperty bisiesto;
    
    public Año(String year){
        this.año = new SimpleStringProperty(year);
        
        this.bisiesto = new SimpleStringProperty(esBisiesto(year));
    }
    
    public String getAño(){
        return this.año.get();
    }
    
    public String getBisiesto(){
        return this.bisiesto.get();
    }
    
    public static String esBisiesto(String year){
        try {
            int intYear = Integer.parseInt(year);
            
            return intYear % 4 == 0 && (intYear % 100 != 0 || intYear % 400 == 0)
                    ? "BISIESTO"
                    : "NO BISIESTO";
        } catch (NumberFormatException e) {
            return "NO VALIDO";
        }
        
        
    }
}
