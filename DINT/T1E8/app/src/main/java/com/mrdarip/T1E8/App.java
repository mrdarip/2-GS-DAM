package com.mrdarip.T1E8; //Modificar al package correcto

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
Hacer una GUI donde aparezca un TexField(año), un botón y un ListView(lista) asociado a un
ObservableList. Al pulsar el botón deberá ir rellenando el ListView con el texto año-info del tipo
“XXXX” “Bisiesto” o “YYYY NO bisiesto”. Si el tipo de dato es incorrecto deberá avisarlo de
cualquier forma.
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField yearField = new TextField();
        Button addButton = new Button("Añadir");

        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> list = new ListView<>(items);
        
        addButton.setOnAction((event) -> {
            boolean exceptional = false;
            int year = -1;
            try{
                year = Integer.parseInt(yearField.getText());
            }catch(Exception e){
                exceptional=true;
            }
            
            items.add(
                    yearField.getText() + "-" + 
                            
                    (exceptional?
                        "NO VALIDO":
                        (
                            year % 4 ==0 && (year % 100 != 0 || year % 400 == 0)?
                                    "BISIESTO":
                                    "NO BISIESTO"
                        )
                    ));
            
            yearField.clear();
        });

        VBox vbox = new VBox(10,
                list,
                new HBox(10, yearField, addButton)
        ); //Layout padre (contenedor de nodos). 10 px separación

        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
