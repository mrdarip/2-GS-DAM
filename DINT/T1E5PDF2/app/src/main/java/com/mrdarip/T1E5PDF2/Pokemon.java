/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrdarip.T1E5PDF2;

import java.net.URI;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Pokemon {
    
    int pokedexNumber;
    String name;
    Color color;
    String srcImageUri;
    EventHandler<ActionEvent> onDelete = ((t) -> {
        System.out.println("no implementado");
    });

    public Pokemon(int pokedexNumber, String name, Color color, String srcImageUri) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.color = color;
        this.srcImageUri = srcImageUri;
    }

    public Pane getAsPane() {
        ImageView image = new ImageView(this.srcImageUri);
        image.setFitWidth(64.);
        image.setFitHeight(64.);
       
        
        Label name = new Label(this.name);
        
        Button deleteButton = new Button("Borrar");
        deleteButton.setOnAction(onDelete);
        
        Button infoButton = new Button("Ver info");
        infoButton.setOnAction((t) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(this.toString());
            alert.showAndWait();
        });
        
        VBox box = new VBox(image, name, infoButton, deleteButton);

        
        Pane pane = new Pane(box);
        BackgroundFill fondoColor = new BackgroundFill(this.color, new CornerRadii(0), null);
        pane.setBackground(new Background(fondoColor));
        return pane;
    }

    @Override
    public String toString() {
        return "numero pokedex: " + this.pokedexNumber
                + "\nnombre: " + this.name
                + "\ncolor: " + this.color.toString()
                + "\nimagen: " + this.srcImageUri;
    }

}
