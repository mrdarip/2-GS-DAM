package com.mrdarip.T1E7; //Modificar al package correcto

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
Hacer una GUI donde aparezca un TextField(nota), dos botones(“Añadir” y “Calcular”) y un
ListView. Cada vez que se pulse el botón de “Añadir” meterá la nota en el ListView y cada vez
que pulsemos en el botón de “Calcular” deberá indicar la mayor nota, la menor y la media.
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField markField = new TextField();

        Button addButton = new Button("Añadir");
        Button calcButton = new Button("Calcular");
        
        ObservableList<Integer> items = FXCollections.observableArrayList();

        ListView<Integer> list = new ListView<>(items);
        

        calcButton.setOnAction((event) -> {
            SortedList<Integer> sortedItems = items.sorted();
            int maxMark = sortedItems.getLast();
            int minMark = sortedItems.getFirst();
            int markSum = items.stream().mapToInt(n -> n).sum();
            double markAvg = (double)markSum/(double)items.size();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(
                    "Mayor nota: " + maxMark +
                    "Menor nota: " + minMark + 
                    "Nota media: " + markAvg
            
            );
            
            alert.showAndWait();
            
            items.clear();
        });

        addButton.setOnAction((event) -> {
            int mark = Integer.parseInt(markField.getText());
            markField.clear();
            
            items.add(mark);
        });

        VBox vbox = new VBox(10,
                markField,
                new HBox(10, addButton, calcButton),
                list
        ); //Layout padre (contenedor de nodos). 10 px separación

        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
