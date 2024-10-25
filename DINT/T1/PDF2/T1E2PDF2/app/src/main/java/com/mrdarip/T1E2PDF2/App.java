package com.mrdarip.T1E2PDF2;

import java.util.Collections;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};

        Pane[] panes = new Pane[colors.length];
        Button[] buttons = new Button[colors.length];

        for (int i = 0; i < panes.length; i++) {
            panes[i] = new Pane(new Label("Label " + i));

            BackgroundFill fondoColor = new BackgroundFill(colors[i], new CornerRadii(0), null);
            panes[i].setBackground(new Background(fondoColor));
        }

        Tab[] tabs = new Tab[3];

        for (int i = 0; i < tabs.length; i++) {
            tabs[i] = new Tab("Tab " + i);
        }

        panes[0].getChildren().add(
                new TabPane(tabs)
        );

        StackPane stackPane = new StackPane(panes[0]);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("boton " + i);
            Pane pane = panes[i];

            buttons[i].setOnAction((event) -> {
                stackPane.getChildren().set(0, pane);
            });
        }

        ToolBar toolBar = new ToolBar(buttons);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setCenter(stackPane);

        Scene scene = new Scene(borderPane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
