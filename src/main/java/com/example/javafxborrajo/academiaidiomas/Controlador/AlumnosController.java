package com.example.javafxborrajo.academiaidiomas.Controlador;

import com.example.javafxborrajo.academiaidiomas.Modelo.Alumno;
import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloAlumnos;
import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloProfesores;
import com.example.javafxborrajo.academiaidiomas.Modelo.Profesor;
import com.example.javafxborrajo.academiaidiomas.Vista.AlumnosView;
import javafx.scene.control.Alert;

public class AlumnosController {
    private final AlumnosView vista;
    private final ModeloAlumnos modeloAlumnos;

    public AlumnosController(AlumnosView vista, ModeloProfesores modeloProfesores, ModeloAlumnos modeloAlumnos) {
        this.vista = vista;
        this.modeloAlumnos = modeloAlumnos;

        vista.cmbProfesores.setItems(modeloProfesores.getListaProfesores());

        vista.btnBuscar.setOnAction(e -> buscar());

        // Editar solo visible con un alumno seleccionado
        vista.tabla.getSelectionModel().selectedItemProperty().addListener((obs, viejo, nuevo) -> {
            vista.btnEditar.setVisible(nuevo != null);
            vista.btnEditar.setManaged(nuevo != null);
        });

        vista.btnEditar.setOnAction(e -> mostrarFormulario());
        vista.btnGuardar.setOnAction(e -> guardar());
        vista.btnOcultar.setOnAction(e -> ocultarFormulario());
    }

    private void buscar() {
        Profesor p = vista.cmbProfesores.getValue();
        if (p == null) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("Selecciona un profesor antes de buscar");
            a.showAndWait();
            return;
        }
        vista.tabla.setItems(modeloAlumnos.getAlumnosDeProfesor(p.getId()));
        vista.tabla.getSelectionModel().selectFirst();
    }

    private void mostrarFormulario() {
        Alumno a = vista.tabla.getSelectionModel().getSelectedItem();
        if (a == null) return;
        vista.txtNombre.setText(a.getNombreAlumno());
        vista.cmbNivel.setValue(a.getNivel());
        vista.txtTelefono.setText(a.getTelefono());
        vista.txtEmail.setText(a.getEmail());
        vista.txtObservaciones.setText(a.getObservaciones());
        vista.formulario.setVisible(true);
        vista.formulario.setManaged(true);
        vista.getScene().getWindow().sizeToScene();
    }

    private void guardar() {
        Alumno a = vista.tabla.getSelectionModel().getSelectedItem();
        if (a == null) return;
        a.setNombreAlumno(vista.txtNombre.getText());
        a.setNivel(vista.cmbNivel.getValue());
        a.setTelefono(vista.txtTelefono.getText());
        a.setEmail(vista.txtEmail.getText());
        a.setObservaciones(vista.txtObservaciones.getText());
        vista.tabla.refresh();
    }

    private void ocultarFormulario() {
        vista.txtNombre.clear();
        vista.cmbNivel.setValue(null);
        vista.txtTelefono.clear();
        vista.txtEmail.clear();
        vista.txtObservaciones.clear();
        vista.formulario.setVisible(false);
        vista.formulario.setManaged(false);
        vista.getScene().getWindow().sizeToScene();
    }
}
