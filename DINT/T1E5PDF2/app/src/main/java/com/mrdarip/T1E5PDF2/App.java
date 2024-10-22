package com.mrdarip.T1E5PDF2;

import com.mrdarip.T1E5PDF2.AddPokemonPane;
import com.mrdarip.T1E5PDF2.Pokemon;
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class App extends Application {

    // Declare instance variables
    private ObservableList<Pane> panes;
    private ObservableList<Pokemon> pokemons;
    private GridPane gridPane;
    private final int columns = 6;
    
    StackPane stackPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        panes = FXCollections.observableArrayList(); // Initialize the panes list
        pokemons = FXCollections.observableArrayList();

        gridPane = new GridPane();  // Initialize the gridPanes

        AddPokemonPane addPokemonPane = new AddPokemonPane();
        
        addPokemonPane.createB.setOnAction((event)->{
                Pokemon pokemon = addPokemonPane.getPokemon();
                addPokemon(pokemon);
                stackPane.getChildren().getLast().toBack();
                rebuildGridFromRow(0);
        });

        Pane addPokemonPanePane = addPokemonPane.getPane();
        stackPane = new StackPane(gridPane, addPokemonPanePane);

        // Fill the grid with 20 Pokemon Pane objects
        for (int i = 0; i < 20; i++) {
            addPokemon(
                    new Pokemon(
                            i,
                            "pokemon " + i,
                            Color.grayRgb((int) (Math.random() * 128 + 127)),
                            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + i + ".png"
                    )
            );
        }

        // Initially build the entire grid
        rebuildGridFromRow(0);

        Button addPokemon = new Button("Add");
        
        addPokemon.setOnAction((eh)->{
            int addIndex = stackPane.getChildren().indexOf(addPokemonPanePane);
            stackPane.getChildren().get(addIndex).toFront();
        });
        
        Scene scene = new Scene(new VBox(stackPane,addPokemon), 500, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addPokemon(Pokemon pokemon) {
        // Set the delete button action for each Pokémon
        pokemon.onDelete = (event) -> {
            // Remove the corresponding Pokemon and its Pane
            panes.remove(pokemons.indexOf(pokemon));
            pokemons.remove(pokemon);

            // Rebuild the grid from the start
            rebuildGridFromRow(0);
        };

        final Pane pokepane = pokemon.getAsPane();

        pokemons.add(pokemon);
        panes.add(pokepane);

    }

    // Method to rebuild the grid from a specific row
    private void rebuildGridFromRow(int startRow) {
        Node[] panesAsArray = panes.stream().toArray(Node[]::new);

        // Remove all rows from startRow onward
        gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) >= startRow);

        // Calculate the number of rows
        int rows = (int) Math.ceil((double) panesAsArray.length / (double) columns);

        // Rebuild the grid from the specified row
        for (int i = startRow; i < rows; i++) {
            int from = i * columns;
            int to = Math.min((i + 1) * columns, panesAsArray.length);

            Node[] rowNodes = Arrays.copyOfRange(panesAsArray, from, to);

            // Add the nodes to the grid row by row
            gridPane.addRow(i, rowNodes);
        }
    }
}
