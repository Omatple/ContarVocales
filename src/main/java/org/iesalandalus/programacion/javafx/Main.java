package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.utilidades.Dialogos;

public class Main extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        Controlador ventanaPrincipal = Controladores.get("/vistas/VentanaContarVocales.fxml", "CONTAR VOCALES", null);
        ventanaPrincipal.getEscenario().show();
        ventanaPrincipal.getEscenario().setOnCloseRequest(e -> confirmacionSalirAspa(e, ventanaPrincipal.getEscenario()));
    }

    void confirmacionSalirAspa(javafx.stage.WindowEvent evento, Stage escenario) {
        if (!Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", escenario)) {
            evento.consume();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
