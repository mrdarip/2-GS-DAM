package com.mrdarip.T1E1PDF2; //Modificar al package correcto

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    int initialAttempts = 5;
    int attempts = initialAttempts;
    
    String user = "Dario";
    String password ="plokijuhygtfrdeswaq";
    
    @Override
    public void start(Stage primaryStage) {

        Label loginLabel = new Label("Login Username and Password");

        Label userLabel = new Label("user:");
        TextField userTextField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passworTextField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setAlignment(Pos.CENTER);
        
        Image image = new Image("https://th.bing.com/th/id/OIP.8hjfJpy1QT2Z3VnoVCkAUQHaHa?rs=1&pid=ImgDetMain");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        

        loginButton.setOnAction((event) -> {
            if(passworTextField.getText().equals(password) && userTextField.getText().equals(user)){
                attempts= initialAttempts;
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                
                alert.setHeaderText("contraseña correcta");
                alert.setContentText("hola "+ userTextField.getText() + " con contraseña "+ passworTextField.getText());
                
                alert.showAndWait();
            }else{
                attempts--;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Contraseña incorrecta");
                
                
                alert.showAndWait();
            
                if(attempts<=0){
                    alert.setContentText("Has superado los "+initialAttempts+" intentos\nLa aplicación se cerrará");
                    alert.showAndWait();
                    System.exit(0);
                }
            }
        });

        StackPane vbox = new StackPane( 
                new HBox(loginLabel, imageView), 
                userLabel, 
                userTextField, 
                passwordLabel, 
                passworTextField, 
                loginButton); //Layout padre (contenedor de nodos). 10 px separación
        vbox.setPadding(new Insets(20));//Borde interno 20px
        Scene scene = new Scene(vbox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
