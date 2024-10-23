module com.example.viacostafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.viacostafx to javafx.fxml;
    opens Controller to javafx.fxml; // Añadido para exportar Controller

    exports com.example.viacostafx;
}