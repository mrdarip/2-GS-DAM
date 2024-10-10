package com.mrdarip.T1E9;

import java.time.Year;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
Repetir el ejercicio anterior pero en vez de un ListView utilizar un TableView asociado a un
ObservableList<Año> con dos columnas: año y bisiesto. Habrá que hacer una clase para
almacenar los elementos tipo “Año”:
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField yearField = new TextField();
        Button addButton = new Button("Añadir");

        ObservableList<Año> items = FXCollections.observableArrayList();
        TableView table = new TableView<>(items);
        
        TableColumn yearColumn = new TableColumn("Year");
        yearColumn.setCellValueFactory(
                new PropertyValueFactory<Año, String>("año"));
        
        TableColumn bisiestoColumn = new TableColumn("Bisiesto");
        bisiestoColumn.setCellValueFactory(
                new PropertyValueFactory<Año, String>("bisiesto"));

        table.getColumns().addAll(yearColumn, bisiestoColumn);

        addButton.setOnAction((event) -> {
            items.add(new Año(yearField.getText()));
            
            yearField.clear();
        });

        VBox vbox = new VBox(10,
                table,
                new HBox(10, yearField, addButton)
        ); //Layout padre (contenedor de nodos). 10 px separación

        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
