package com.example.javafxborrajo.academiaidiomas.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.time.LocalDate;

public class LoginView extends BorderPane {
    public TextField txtCodigo;
    public RadioButton rbProfesor, rbSecretaria, rbDireccion;
    public ToggleGroup grupoPerfil;
    public Button btnEntrar, btnSalir;
    public ImageView imagen;

    public LoginView() {
        // Arriba
        Label titulo = new Label("Academia de Idiomas");
        titulo.getStyleClass().add("titulo");
        BorderPane.setAlignment(titulo, Pos.CENTER);
        setTop(titulo);

        // Formulario
        txtCodigo = new TextField();
        txtCodigo.setPromptText("AB1234");

        rbProfesor = new RadioButton("Profesor");
        rbSecretaria = new RadioButton("Secretaría");
        rbDireccion = new RadioButton("Dirección");
        grupoPerfil = new ToggleGroup();
        rbProfesor.setToggleGroup(grupoPerfil);
        rbSecretaria.setToggleGroup(grupoPerfil);
        rbDireccion.setToggleGroup(grupoPerfil);
        VBox perfiles = new VBox(8, rbProfesor, rbSecretaria, rbDireccion);

        btnEntrar = new Button("Entrar");
        btnSalir = new Button("Salir");
        btnSalir.setId("btnSalir");
        HBox botones = new HBox(30, btnEntrar, btnSalir);

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(12);
        form.add(new Label("Código de empleado:"), 0, 0);
        form.add(txtCodigo, 1, 0);
        form.add(new Label("Seleccione su perfil"), 0, 1, 2, 1);
        form.add(perfiles, 0, 2, 2, 1);
        form.add(botones, 0, 3, 2, 1);

        imagen = new ImageView(new Image(getClass()
                .getResource("/com/example/academia/logo-academia.png").toExternalForm()));
        imagen.setFitWidth(140);
        imagen.setPreserveRatio(true);

        Region relleno = new Region();
        HBox.setHgrow(relleno, Priority.ALWAYS);
        HBox centro = new HBox(20, form, relleno, imagen);
        centro.setPadding(new Insets(20, 30, 20, 30));
        centro.setAlignment(Pos.CENTER_LEFT);
        setCenter(centro);

        // Pie
        HBox pie = new HBox(30,
                new Label("© " + LocalDate.now().getYear() + " Academia de Idiomas"),
                new Label("Contacto: info@academia.es | +34 988 111 222"));
        pie.setAlignment(Pos.CENTER);
        pie.getStyleClass().add("pie");
        setBottom(pie);
    }
}
