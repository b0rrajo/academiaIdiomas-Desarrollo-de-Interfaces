package com.example.javafxborrajo.academiaidiomas.Controlador;

import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloAlumnos;
import com.example.javafxborrajo.academiaidiomas.Modelo.ModeloProfesores;
import com.example.javafxborrajo.academiaidiomas.Vista.AlumnosView;
import com.example.javafxborrajo.academiaidiomas.Vista.LoginView;
import com.example.javafxborrajo.academiaidiomas.Vista.VentanaAlumnos;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {
    private final Stage stage;
    private final LoginView vista;
    private final ModeloProfesores modeloProfesores;
    private final ModeloAlumnos modeloAlumnos;

    public LoginController(Stage stage, LoginView vista,
                           ModeloProfesores modeloProfesores, ModeloAlumnos modeloAlumnos) {
        this.stage = stage;
        this.vista = vista;
        this.modeloProfesores = modeloProfesores;
        this.modeloAlumnos = modeloAlumnos;
        iniciarEventos();
    }

    private void iniciarEventos() {
        // Teclado: 2 letras + 4 dígitos, máximo 6 caracteres
        vista.txtCodigo.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            String c = e.getCharacter();
            if (c.isEmpty() || c.charAt(0) < 32 || c.charAt(0) == 127) {
                return; // teclas de control (borrar, etc.)
            }
            int pos = vista.txtCodigo.getText().length();
            boolean valido;
            if (pos >= 6) {
                valido = false;
            } else if (pos < 2) {
                valido = Character.isLetter(c.charAt(0));
            } else {
                valido = Character.isDigit(c.charAt(0));
            }
            if (!valido) {
                e.consume();
            }
        });

        vista.btnEntrar.setOnAction(e -> entrar());
        vista.btnSalir.setOnAction(e -> Platform.exit());
    }

    private void entrar() {
        String codigo = vista.txtCodigo.getText();
        if (codigo.isEmpty()) {
            aviso("El código de empleado no puede estar vacío");
            vista.txtCodigo.clear();
        } else if (!codigo.matches("[a-zA-Z]{2}[0-9]{4}")) {
            aviso("El código debe tener 6 caracteres: 2 letras y 4 dígitos (por ejemplo, AB1234)");
            vista.txtCodigo.clear();
        } else if (vista.grupoPerfil.getSelectedToggle() == null) {
            aviso("El perfil es obligatorio. Por favor, selecciona un perfil");
            vista.rbDireccion.setSelected(true);
        } else {
            AlumnosView av = new AlumnosView();
            new AlumnosController(av, modeloProfesores, modeloAlumnos);
            new VentanaAlumnos(stage, av).showAndWait();
        }
    }

    private void aviso(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
