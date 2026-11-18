package com.example.javafxborrajo.academiaidiomas.Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeloAlumnos {
    private final ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();

    public ModeloAlumnos() {
        listaAlumnos.add(new Alumno("Daniel Borrajo", "663233630", "danielborrajofde@gmail.com", "Progresa Bien", "001", Nivel.Basico));
        listaAlumnos.add(new Alumno("Otilia Fernandez", "610300303", "otiliarguez@gmail.com", "Progresa Bien", "002", Nivel.Basico));
        listaAlumnos.add(new Alumno("Francisco Borrajo", "667604572", "paco.borrajo@gmail.com", "Progresa Bien", "003", Nivel.Basico));
        listaAlumnos.add(new Alumno("Genaro Borrajo", "123456789", "usuario@servidor.extdominio", "Progresa Bien", "001", Nivel.Basico));
        listaAlumnos.add(new Alumno("Milagros Martinez", "123456789", "usuario@servidor.extdominio", "Progresa Bien", "002", Nivel.Basico));

    }

    public ObservableList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public ObservableList<Alumno> getAlumnosDeProfesor(int idProfesor) {
        ObservableList<Alumno> resultado = FXCollections.observableArrayList();
        for (Alumno a : listaAlumnos) {
            if (a.getIdProfesor().equals(idProfesor)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
