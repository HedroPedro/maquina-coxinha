module com.maquina {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.maquina to javafx.fxml;
    exports com.maquina;
}
