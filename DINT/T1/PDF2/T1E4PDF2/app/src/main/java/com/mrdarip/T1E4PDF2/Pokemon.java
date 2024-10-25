/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrdarip.T1E4PDF2;

import java.net.URI;
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

    public Pokemon(int pokedexNumber, String name, Color color, String srcImageUri) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.color = color;
        this.srcImageUri = srcImageUri;
    }
    
    public Pane getAsPane(){
        ImageView image = new ImageView(this.srcImageUri);
        Label name = new Label(this.name);
        Button button = new Button("Ver info");
        button.setOnAction((t) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(this.toString());
            alert.showAndWait();
        });
        VBox box = new VBox(image, name, button);
        
        Pane pane = new Pane(box);
        
        BackgroundFill fondoColor = new BackgroundFill(this.color, new CornerRadii(0), null);
        pane.setBackground(new Background(fondoColor));
        
        return pane;
    }
    
    @Override
    public String toString(){
        return 
                "numero pokedex: "+ this.pokedexNumber+
                "\nnombre: " + this.name+
                "\ncolor: "+ this.color.toString()+
                "\nimagen: " + this.srcImageUri;
    }
            
           
    
    
}
