module com.github.sithumonline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.github.sithumonline to javafx.fxml;
    opens com.github.sithumonline.view.handler to javafx.fxml;
    opens com.github.sithumonline.model to javafx.base;
    exports com.github.sithumonline;
    exports com.github.sithumonline.view.handler;
}