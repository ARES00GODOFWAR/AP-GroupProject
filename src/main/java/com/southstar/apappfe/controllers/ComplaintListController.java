package com.southstar.apappfe.controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ComplaintListController {
    @FXML
    private Button dBtn;

    @FXML
    private Pane contentPane;

    @FXML
    private Button makeComplaintButton;

    @FXML
    private void openDashboard(ActionEvent event) throws IOException {

        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/dashboard.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }
    @FXML
    private void openPayments(ActionEvent event) throws IOException {

        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/listOfPayments.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }
    @FXML
    private void makeComplaints(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/complaintPage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        makeComplaintButton.arm();
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> {
                    makeComplaintButton.disarm();
                   // makeComplaintButton.fire();
                }
        );
        pause.play();
        contentPane.getScene().setRoot(root);
    }
}
