package com.example.javafxborrajo.academiaidiomas.Vista;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VentanaAlumnos extends Stage {
    public VentanaAlumnos(Stage madre, AlumnosView vista) {
        setTitle("Fichas de alumnos");
        initOwner(madre);
        initModality(Modality.APPLICATION_MODAL);
        Scene escena = new Scene(vista);
        escena.getStylesheets().add(getClass()
                .getResource("/com/example/academia/estilos.css").toExternalForm());
        setScene(escena);
    }
}