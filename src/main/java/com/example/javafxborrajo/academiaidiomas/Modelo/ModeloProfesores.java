package com.example.javafxborrajo.academiaidiomas.Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloProfesores {
    ObservableList<Profesor> profesores = FXCollections.observableArrayList();
    public ObservableList<Profesor> getListaProfesores() {
        return profesores;
    }
}
