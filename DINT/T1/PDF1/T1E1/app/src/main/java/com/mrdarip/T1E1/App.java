package com.mrdarip.T1E1; //Modificar al package correcto

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        Label priceLB = new Label("Precio:");
        Label discountLB = new Label("Descuento:");
        
        TextField priceTF = new TextField();
        TextField discountTF = new TextField();
        
        Button calcB = new Button("Calcular");
        
        calcB.setOnAction((event)->{
            double price = Double.parseDouble(priceTF.getText());
            double discount = Double.parseDouble(discountTF.getText());
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Descuento aplicado. Precio inicial: "+ price);
            alert.setContentText("Descuento: " + discount + "\nPrecio final: " + (price * (1-(discount/100))));
            alert.showAndWait();
        });

        VBox vbox = new VBox(10,priceLB,priceTF,discountLB,discountTF, calcB); //Layout padre (contenedor de nodos). 10 px separación
        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
