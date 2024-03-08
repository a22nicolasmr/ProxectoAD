module com.example.proxectoadfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;


    opens com.example.proxectoadfx to javafx.fxml;
    opens entities;
    exports com.example.proxectoadfx;
    exports entities;
}
