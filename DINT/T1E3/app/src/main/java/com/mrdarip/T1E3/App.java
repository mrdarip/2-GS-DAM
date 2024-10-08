package com.mrdarip.T1E3; //Modificar al package correcto

import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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

        Label conversionLabel = new Label("Converstir:");

        TextField eurosTextField = new TextField();
        
        Map<String,Double> conversions = Map.of(
                "EUR",1.,
                "GBP",0.5,
                "ABC",5.1,
                "WWW",0.01,
                "RUP",1.2
        );
        
        ObservableList<String> options = FXCollections.observableArrayList(conversions.keySet());
        
        ChoiceBox<String> box = new ChoiceBox<>(options);

        Button calcButton = new Button("Calcular");

        calcButton.setOnAction((event) -> {
            String optionSelected = box.getValue();
            
            double euros = Double.parseDouble(eurosTextField.getText());
            double conversionRate = conversions.get(optionSelected);
            
            double convertedEuros = euros * conversionRate;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("EUR a " + optionSelected);
            alert.setContentText(euros + "EUR = " + convertedEuros + optionSelected);
            alert.showAndWait();
        });

        VBox vbox = new VBox(10, conversionLabel,eurosTextField,box,calcButton); //Layout padre (contenedor de nodos). 10 px separación
        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
