package com.example.viacostafx;

import com.example.viacostafx.Modelo.JPAUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            JPAUtils.getEntityManagerFactory();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/GUI/InterfazPrincipal.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1079);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void stop() {
        // Cerrar JPA al cerrar la aplicación
        JPAUtils.shutdown();
    }

    public static void main(String[] args) {
        launch();

    }


}