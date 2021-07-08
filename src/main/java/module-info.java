module com.github.sithumonline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.github.sithumonline to javafx.fxml;
    opens com.github.sithumonline.handler to javafx.fxml;
    exports com.github.sithumonline;
    exports com.github.sithumonline.handler;
}