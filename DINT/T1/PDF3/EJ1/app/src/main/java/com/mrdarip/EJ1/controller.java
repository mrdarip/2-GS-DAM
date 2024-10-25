/**
 * Sample Skeleton for 'interface' Controller Class
 */
package com.mrdarip.EJ1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controller implements Initializable{

    
    @FXML
    private Button calcBtn;

    @FXML
    private TextField descuentoTf;

    @FXML
    private TextField precioTf;

    @FXML
    void Calcular() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        double precio = Double.parseDouble(precioTf.getText());
        double descuento = 1 - Double.parseDouble(descuentoTf.getText())/100;
        alert.setContentText("" + precio * descuento);
        
        alert.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
