package com.mrdarip.T1E4PDF2;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
Crea un GridPane de 4x4. Haz que se rellene con Pane personalizado que contengan datos de
Cervezas. Para ello tendrás que crear un modelo y rellenar un OL. Dicho modelo tendrá: una
imagen, un nombre, nacionalidad y grados. Además, el Pane tendrá un botón que al pulsar nos
deberá de sacar toda la información individual de dicho item en un ALERT (de la imagen solo
sacará la url, no mostrará la imagen en sí en el ALERT).
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        final int columns = 4;

        ObservableList<Pokemon> pokemons = FXCollections.observableArrayList();
        ObservableList<Pane> panes = FXCollections.observableArrayList();

        for (int i = 0; i < 20; i++) {
            pokemons.add(new Pokemon(i, "pokemon " + i, Color.grayRgb((int)(Math.random() * 128 +127)), "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + i + ".png"));

            panes.add(pokemons.get(i).getAsPane());
        }

        Node[] panesAsArray = panes.stream().toArray(Node[]::new);

        int rows = (int) Math.ceil((double)panesAsArray.length / (double)columns);
        for (int i = 0; i < rows; i++) {
            int from = i * columns;
            int to = Math.min((i + 1) * columns, panesAsArray.length);
            
            Node[] rowNodes = Arrays.copyOfRange(panesAsArray, from, to);
            
            gridPane.addRow(i, rowNodes);
        }


        Scene scene = new Scene(gridPane, 500, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
