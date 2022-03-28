package com.southstar.apappfe.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RepDashboardController {
    @FXML
    private Button cBtn;

    @FXML
    private Pane contentPane;


    @FXML
    private void openComplaints(ActionEvent event) throws IOException {
        System.out.println("This works");
        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/complaintPage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }
}
