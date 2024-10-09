package com.mrdarip.T1E4; //Modificar al package correcto

import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label conversionLabel = new Label("Converstir:");

        TextField eurosTextField = new TextField();
        
        Map<String,Double> conversions = Map.of(
                "EUR",1.,
                "GBP",0.5,
                "ABC",5.1,
                "WWW",0.01,
                "RUP",1.2
        );
        
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        
        ToggleGroup group = new ToggleGroup();
        
        conversions.forEach((k, v) -> {
            RadioButton radioButtonToAdd = new RadioButton(k);
            radioButtonToAdd.setToggleGroup(group);
            radioButtons.add(radioButtonToAdd);
        });

        Button calcButton = new Button("Calcular");

        calcButton.setOnAction((event) -> {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String optionSelected = selectedRadioButton.getText();
            
            double euros = Double.parseDouble(eurosTextField.getText());
            double conversionRate = conversions.get(optionSelected);
            
            double convertedEuros = euros * conversionRate;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("EUR a " + optionSelected);
            alert.setContentText(euros + "EUR = " + convertedEuros + optionSelected);
            alert.showAndWait();
        });

        VBox vbox = new VBox(10, conversionLabel,eurosTextField); //Layout padre (contenedor de nodos). 10 px separación
        
        radioButtons.forEach((radio)->{
            vbox.getChildren().add(radio);
        });
        
        vbox.getChildren().add(calcButton);
        
        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
