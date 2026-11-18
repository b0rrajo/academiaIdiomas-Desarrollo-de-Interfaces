package com.example.javafxborrajo.academiaidiomas.Modelo;

public class Alumno {
    public String nombreAlumno, telefono, email, observaciones, idProfesor;
    public Nivel nivel;

    public Alumno(String nombreAlumno, String telefono, String email, String observaciones, String idProfesor, Nivel nivel) {
        this.nombreAlumno = nombreAlumno;
        this.telefono = telefono;
        this.email = email;
        this.observaciones = observaciones;
        this.idProfesor = idProfesor;
        this.nivel = nivel;
    }
    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
    public Nivel getNivel() {
        return nivel;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
