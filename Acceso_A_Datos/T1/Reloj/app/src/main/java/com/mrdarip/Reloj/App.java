package com.mrdarip.Reloj;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import java.io.*;
import java.util.Properties;

public class App extends Application {

    private TextField inputField;
    private ProgressBar progressBar;
    private Label tiempoLabel;
    private Button iniciarButton;
    private Button cancelarButton;
    private Button guardarButton;
    private Button cargarButton;
    private CheckBox temaOscuroCheckbox;
    private int tiempoTotal;
    private int tiempoActual;
    private boolean contando;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Contador de Tiempo");
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label instruccionLabel = new Label("Introduce el tiempo en segundos:");
        inputField = new TextField();
        progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(200);
        tiempoLabel = new Label("Tiempo: 00:00:00");
        iniciarButton = new Button("Iniciar");
        cancelarButton = new Button("Cancelar");
        guardarButton = new Button("Guardar Tiempo");
        cargarButton = new Button("Cargar Tiempo");
        temaOscuroCheckbox = new CheckBox("Tema oscuro");

        cancelarButton.setDisable(true);
        root.getChildren().addAll(instruccionLabel, inputField, progressBar, tiempoLabel, iniciarButton,
                cancelarButton, guardarButton, cargarButton, temaOscuroCheckbox);

        iniciarButton.setOnAction(e -> iniciarContador());
        cancelarButton.setOnAction(e -> cancelarContador());
        guardarButton.setOnAction(e -> guardarTiempo());
        cargarButton.setOnAction(e -> cargarTiempo());
        temaOscuroCheckbox.setOnAction(e -> cambiarTema(root));

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void iniciarContador() {
        try {
            tiempoTotal = Integer.parseInt(inputField.getText());
            if (tiempoTotal <= 0) {
                throw new NumberFormatException();
            }
            tiempoActual = 0;
            contando = true;
            progressBar.setProgress(0);
            iniciarButton.setDisable(true);
            cancelarButton.setDisable(false);
            inputField.setDisable(true);
            new Thread(() -> {
                while (contando && tiempoActual < tiempoTotal) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                    tiempoActual++;
                    Platform.runLater(this::actualizarUI);
                }
                if (tiempoActual >= tiempoTotal) {
                    Platform.runLater(this::finalizarContador);
                }
            }).start();
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, introduce un número válido mayor que cero.");
            alert.showAndWait();
        }
    }

    private void cancelarContador() {
        contando = false;
        reiniciarUI();
    }

    private void finalizarContador() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tiempo completado");
        alert.setHeaderText(null);
        alert.setContentText("¡El tiempo ha finalizado!");
        alert.showAndWait();

        // Sonido de alerta
        AudioClip sonidoAlerta = new AudioClip(getClass().getResource("/sonido/alerta.mp3").toString());
        sonidoAlerta.play();

        reiniciarUI();
    }

    private void actualizarUI() {
        double progreso = (double) tiempoActual / tiempoTotal;
        progressBar.setProgress(progreso);
        tiempoLabel.setText("Tiempo: " + formatearTiempo(tiempoActual));
    }

    private String formatearTiempo(int segundos) {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segs = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segs);
    }

    private void reiniciarUI() {
        iniciarButton.setDisable(false);
        cancelarButton.setDisable(true);
        inputField.setDisable(false);
        progressBar.setProgress(0);
        tiempoLabel.setText("Tiempo: 00:00:00");
    }

    private void cambiarTema(VBox root) {
        if (temaOscuroCheckbox.isSelected()) {
            root.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
            tiempoLabel.setTextFill(Color.WHITE);
        } else {
            root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            tiempoLabel.setTextFill(Color.BLACK);
        }
    }

    private void guardarTiempo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar tiempo predefinido");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Propiedades", "*.properties"));
        File archivo = fileChooser.showSaveDialog(null);

        if (archivo != null) {
            Properties propiedades = new Properties();
            propiedades.setProperty("tiempoPredefinido", inputField.getText());
            try (FileOutputStream output = new FileOutputStream(archivo)) {
                propiedades.store(output, "Tiempo predefinido");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cargarTiempo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Cargar tiempo predefinido");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Propiedades", "*.properties"));
        File archivo = fileChooser.showOpenDialog(null);

        if (archivo != null) {
            Properties propiedades = new Properties();
            try (FileInputStream input = new FileInputStream(archivo)) {
                propiedades.load(input);
                String tiempoGuardado = propiedades.getProperty("tiempoPredefinido");
                inputField.setText(tiempoGuardado);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
