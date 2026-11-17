package com.example.javafxborrajo.academiaidiomas.Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloAlumnos {
    ObservableList<Alumno> alumnos;
    public ModeloAlumnos(ObservableList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public ObservableList<Alumno> getListaAlumnos() {
        return alumnos;
    }
    public ObservableList<Alumno> getAlumnosDeProfesores(String idProfesor) {
        ObservableList<Alumno> alumnos = FXCollections.observableArrayList();
        for (Alumno alumno : this.alumnos) {
            if (alumno.getIdProfesor().equals(idProfesor)) {
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }
}
