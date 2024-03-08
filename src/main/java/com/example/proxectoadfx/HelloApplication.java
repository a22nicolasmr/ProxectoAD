package com.example.proxectoadfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vbox = new VBox(20);

        Button botonUsuario = new Button("Añadir usuario");
        botonUsuario.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("añadirUsuario.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("Añadir usuario");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button botonProyecto = new Button("Añadir proyecto");
        Button botonTarea = new Button("Añadir tarea");
        Button botonRecordatorio = new Button("Añadir recordatorio");
        Button botonBuscar = new Button("Buscar");

        vbox.getChildren().add(botonUsuario);
        vbox.getChildren().add(botonProyecto);
        vbox.getChildren().add(botonTarea);
        vbox.getChildren().add(botonRecordatorio);
        vbox.getChildren().add(botonBuscar);

        Scene scene = new Scene(vbox, 320, 240);
        stage.setTitle("Que quieres hacer?");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}