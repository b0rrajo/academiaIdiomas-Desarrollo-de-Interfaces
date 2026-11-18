package com.example.javafxborrajo.academiaidiomas.Vista;

import com.example.javafxborrajo.academiaidiomas.Controlador.LoginController;
import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloAlumnos;
import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloProfesores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AcademiaApp extends Application {
    @Override
    public void start(Stage stage) {
        ModeloProfesores modeloProfesores = new ModeloProfesores();
        ModeloAlumnos modeloAlumnos = new ModeloAlumnos();
        LoginView vista = new LoginView();
        new LoginController(stage, vista, modeloProfesores, modeloAlumnos);

        Scene escena = new Scene(vista, 580, 380);
        escena.getStylesheets().add(getClass()
                .getResource("/com/example/academia/estilos.css").toExternalForm());
        stage.setTitle("Academia de Idiomas");
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

