package org.iesalandalus.programacion.javafx.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.iesalandalus.programacion.javafx.utilidades.Controlador;
import org.iesalandalus.programacion.javafx.utilidades.Controladores;
import org.iesalandalus.programacion.javafx.utilidades.Dialogos;

import java.util.Objects;

public class VentanaContarVocales extends Controlador {
    private static final Image IMG_LIMPIAR = new Image(Objects.requireNonNull(VentanaContarVocales.class.getResourceAsStream("/imagenes/limpiar.png")));

    private final VentanaAcercaDe ventanaAcercaDe = (VentanaAcercaDe) Controladores.get("/vistas/VentanaAcercaDe.fxml", "ACERCA DE ...", getEscenario());

    @FXML
    private Button btLimpiar;

    @FXML
    private TextArea taCadena;

    @FXML
    private TextField tfAes;

    @FXML
    private TextField tfEs;

    @FXML
    private TextField tfIes;

    @FXML
    private TextField tfOes;

    @FXML
    private TextField tfUes;

    @FXML
    void acercaDe() {
        ventanaAcercaDe.getEscenario().show();
    }

    @FXML
    void limpiar() {
        taCadena.clear();
        btLimpiar.setDisable(true);
    }

    @FXML
    void salir() {
        if(Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?", getEscenario())) {
            getEscenario().close();
        }
    }

    void comprobarAes(String cadenaMinuscula) {
        int sumaAes = 0;
        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char letra = cadenaMinuscula.charAt(i);
            if (letra == 'a' || letra == 'á') {
                sumaAes++;
            }
        }
        tfAes.textProperty().setValue(String.valueOf(sumaAes));
    }

    void comprobarEs(String cadenaMinuscula) {
        int sumaEs = 0;
        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char letra = cadenaMinuscula.charAt(i);
            if (letra == 'e' || letra == 'é') {
                sumaEs++;
            }
        }
        tfEs.textProperty().setValue(String.valueOf(sumaEs));
    }

    void comprobarIes(String cadenaMinuscula) {
        int sumaIes = 0;
        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char letra = cadenaMinuscula.charAt(i);
            if (letra == 'i' || letra == 'í') {
                sumaIes++;
            }
        }
        tfIes.textProperty().setValue(String.valueOf(sumaIes));
    }

    void comprobarOes(String cadenaMinuscula) {
        int sumaOes = 0;
        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char letra = cadenaMinuscula.charAt(i);
            if (letra == 'o' || letra == 'ó') {
                sumaOes++;
            }
        }
        tfOes.textProperty().setValue(String.valueOf(sumaOes));
    }

    void comprobarUes(String cadenaMinuscula) {
        int sumaUes = 0;
        for (int i = 0; i < cadenaMinuscula.length(); i++) {
            char letra = cadenaMinuscula.charAt(i);
            if (letra == 'u' || letra == 'ú') {
                sumaUes++;
            }
        }
        tfUes.textProperty().setValue(String.valueOf(sumaUes));
    }

    void comprobarVocales() {
        String cadenaMinuscula = taCadena.textProperty().get().toLowerCase();
        comprobarAes(cadenaMinuscula);
        comprobarEs(cadenaMinuscula);
        comprobarIes(cadenaMinuscula);
        comprobarOes(cadenaMinuscula);
        comprobarUes(cadenaMinuscula);
    }

    void habilitarLimpiar() {
        String cadena = taCadena.textProperty().get();
        btLimpiar.setDisable(cadena.isBlank());
    }

    @FXML
    void initialize() {
        btLimpiar.setDisable(true);
        btLimpiar.setGraphic(new ImageView(IMG_LIMPIAR));
        tfAes.setDisable(true);
        tfAes.setEditable(false);
        tfEs.setDisable(true);
        tfEs.setEditable(false);
        tfIes.setDisable(true);
        tfIes.setEditable(false);
        tfOes.setDisable(true);
        tfOes.setEditable(false);
        tfUes.setDisable(true);
        tfUes.setEditable(false);
        tfAes.setText(String.valueOf(0));
        tfEs.setText(String.valueOf(0));
        tfIes.setText(String.valueOf(0));
        tfOes.setText(String.valueOf(0));
        tfUes.setText(String.valueOf(0));
        taCadena.textProperty().addListener(observable -> comprobarVocales());
        taCadena.textProperty().addListener(observable -> habilitarLimpiar());
    }

}
