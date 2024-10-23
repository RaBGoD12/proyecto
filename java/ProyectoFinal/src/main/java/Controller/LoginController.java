package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label txtLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    @FXML


    public void onLoginOnAction(ActionEvent actionEvent) {

        if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("pass")) {
            txtLabel.setText("Bienvenido");
            cargarInterfazPrincipal(actionEvent);


        } else {
            txtLabel.setText("Usuario o contraseña incorrectos" );
        }
    }


    private void cargarInterfazPrincipal (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/InterfazPrincipal.fxml"));
            Parent mainInterfaceRoot = loader.load();

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(mainInterfaceRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            txtLabel.setText("Error al cargar la interfaz principal");
        }
    }




}
