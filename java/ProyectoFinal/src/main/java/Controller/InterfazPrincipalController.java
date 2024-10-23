package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InterfazPrincipalController implements Initializable {
    @FXML
    private ComboBox destinoCombo;
    @FXML
    private DatePicker viajeDate;
    @FXML
    private ComboBox origenCombo;
    @FXML
    private DatePicker retornoDate;
    @FXML
    private Button btnBuscar;
    @FXML
    private GridPane Tabla1; // Vinculamos el GridPane desde el FXML

    private Pane panelSecundario;
    private List<Node> elementosOriginalesTabla1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        elementosOriginalesTabla1 = new ArrayList<>(Tabla1.getChildren());
        btnBuscar.setOnAction(event -> buscarYCargarPanelSecundario());
    }

    @FXML
    private void buscarYCargarPanelSecundario() {
        if (retornoDate.getValue() != null){
            mostrarPanelSecundario();
        }else if (retornoDate.getValue() == null){
            Tabla1.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 0);
            cargarTablaPrincipall();

        }

    }

    private void mostrarPanelSecundario() {
        // Cargamos el Panel Secundario desde el FXML sólo una vez
        if (panelSecundario == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/InterfazSecundaria.fxml"));
                panelSecundario = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("No se pudo cargar el Panel Secundario");
                return;
            }
        }

        // Añadimos el panel secundario al GridPane principal
        if (Tabla1 != null) {
            // Eliminamos cualquier elemento previo en la posición deseada, si es necesario
            Tabla1.getChildren().removeIf(node -> GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == 1);

            // Añadimos el panel secundario en la posición deseada
            Tabla1.add(panelSecundario, 0, 1);

        } else {
            System.out.println("Error: gridPane no está inicializado.");
        }
    }
    private void cargarTablaPrincipall() {
        Tabla1.getChildren().clear();
        Tabla1.getChildren().addAll(elementosOriginalesTabla1);
    }
}