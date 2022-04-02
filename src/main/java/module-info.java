module com.southstar.apappfe {

    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;


    opens com.southstar.apappfe to javafx.fxml;
    exports com.southstar.apappfe;
    exports com.southstar.apappfe.controllers;
    opens com.southstar.apappfe.controllers to javafx.fxml;
}