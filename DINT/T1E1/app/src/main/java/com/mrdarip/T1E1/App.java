package com.mrdarip.T1E1; //Modificar al package correcto

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Plantilla JAVAFX Autor: Curso y año: Objetivo de esta clase:
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox(10); //Layout padre (contenedor de nodos). 10 px separación
        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
