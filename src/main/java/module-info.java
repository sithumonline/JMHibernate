module com.github.sithumonline {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.rmi;

    opens com.github.sithumonline to javafx.fxml;
    opens com.github.sithumonline.view.handler to javafx.fxml;
//    opens com.github.sithumonline.model to javafx.base;
    exports com.github.sithumonline;
    exports com.github.sithumonline.view.handler;
}