package com.example.javafxborrajo.academiaidiomas.Vista;

import com.example.javafxborrajo.academiaidiomas.Modelo.Alumno;
import com.example.javafxborrajo.academiaidiomas.Modelo.Nivel;
import com.example.javafxborrajo.academiaidiomas.Modelo.Profesor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class AlumnosView extends VBox {
    public ComboBox<Profesor> cmbProfesores;
    public Button btnBuscar, btnEditar, btnGuardar, btnOcultar;
    public TableView<Alumno> tabla;
    public TextField txtNombre, txtTelefono, txtEmail;
    public ComboBox<Nivel> cmbNivel;
    public TextArea txtObservaciones;
    public VBox formulario;

    public AlumnosView() {
        setSpacing(12);
        setPadding(new Insets(15));

        cmbProfesores = new ComboBox<>();
        cmbProfesores.setPromptText("Seleccione profesor");
        btnBuscar = new Button("Buscar Alumnos");
        btnEditar = new Button("Editar Alumno");
        btnEditar.setVisible(false);
        btnEditar.setManaged(false);

        HBox fila = new HBox(10, new Label("Profesor:"), cmbProfesores, btnBuscar, btnEditar);
        fila.setAlignment(Pos.CENTER_LEFT);

        tabla = new TableView<>();
        tabla.setPrefSize(680, 150);
        tabla.getColumns().addAll(
                columna("ID Prof", "idProfesor"),
                columna("Alumno", "nombreAlumno"),
                columna("Nivel", "nivel"),
                columna("Teléfono", "telefono"),
                columna("Email", "email"),
                columna("Observaciones", "observaciones"));

        // Formulario
        txtNombre = new TextField();
        cmbNivel = new ComboBox<>();
        cmbNivel.getItems().addAll(Nivel.values());
        txtTelefono = new TextField();
        txtEmail = new TextField();
        txtObservaciones = new TextArea();
        txtObservaciones.setPrefRowCount(3);
        txtObservaciones.setWrapText(true);

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(10);
        grid.add(new Label("Nombre alumno:"), 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(new Label("Nivel:"), 0, 1);
        grid.add(cmbNivel, 1, 1);
        grid.add(new Label("Teléfono:"), 0, 2);
        grid.add(txtTelefono, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(txtEmail, 1, 3);

        btnGuardar = new Button("Guardar");
        btnOcultar = new Button("Ocultar formulario");
        HBox botones = new HBox(20, btnGuardar, btnOcultar);
        botones.setAlignment(Pos.CENTER);

        formulario = new VBox(10, grid, new Label("Observaciones:"), txtObservaciones, botones);
        formulario.setVisible(false);
        formulario.setManaged(false);

        getChildren().addAll(fila, tabla, formulario);
    }

    private TableColumn<Alumno, ?> columna(String titulo, String propiedad) {
        TableColumn<Alumno, Object> col = new TableColumn<>(titulo);
        col.setCellValueFactory(new PropertyValueFactory<>(propiedad));
        return col;
    }
}
