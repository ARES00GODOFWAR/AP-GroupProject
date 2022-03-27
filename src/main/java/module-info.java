module com.southstar.apappfe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.southstar.apappfe to javafx.fxml;
    exports com.southstar.apappfe;
    exports com.southstar.apappfe.controllers;
    opens com.southstar.apappfe.controllers to javafx.fxml;
}