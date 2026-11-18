package com.example.javafxborrajo.academiaidiomas.Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloProfesores {
    private final ObservableList<Profesor> listaProfesores = FXCollections.observableArrayList();

    public ModeloProfesores() {
        listaProfesores.add(new Profesor("Laura Vidal", 001));
        listaProfesores.add(new Profesor("Tom Baker", 002));
        listaProfesores.add(new Profesor("Claire Dubois", 003));
    }

    public ObservableList<Profesor> getListaProfesores() {
        return listaProfesores;
    }
}
