/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrdarip.T1E5PDF2;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author mrdarip
 */
public class AddPokemonPane {
    Label title = new Label("Add new pokemon");

    Input name = new Input("Pokemon name", InputType.TEXT);

    Input number = new Input("Pokedex number", InputType.NUMBER);

    Input color = new Input("Pokemon color", InputType.COLOR);

    Input image = new Input("Pokemon Src image", InputType.TEXT);
    
    
    public Button cancelB = new Button("Cancel");
    public Button createB = new Button("Create");
    
    BorderPane pane = new BorderPane();
    
    public Pane getPane(){
        
        HBox submitBox = new HBox(cancelB, createB);

        VBox mainBox = new VBox(
                title,
                name.asBox(),
                number.asBox(),
                color.asBox(),
                image.asBox(),
                submitBox
        );
        pane.setCenter(mainBox);
        BackgroundFill fondoColor = new BackgroundFill(Color.RED, new CornerRadii(0), null);
        pane.setBackground(new Background(fondoColor));
        return pane;
    }
    
    public Pokemon getPokemon(){
        return new Pokemon(
                (int) number.getValue(), 
                (String) name.getValue(), 
                (Color) color.getValue(),
                (String) image.getValue());
    }
    
    
}
