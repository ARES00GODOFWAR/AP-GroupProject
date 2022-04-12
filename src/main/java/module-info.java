module com.southstar.apappfe {

    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires org.apache.logging.log4j;


    opens com.southstar.apappfe to javafx.fxml;
    exports com.southstar.apappfe;
    exports com.southstar.apappfe.controllers;
    opens com.southstar.apappfe.controllers to javafx.fxml;
    opens com.southstar.Domain to javafx.base;
}