module com.example.javafx_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx_demo to javafx.fxml;
    exports com.example.javafx_demo;
}