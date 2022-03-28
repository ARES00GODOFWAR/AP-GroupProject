package com.southstar.apappfe.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Login {

    @FXML
    private TextField Id;
    private TextField Password;

    @FXML
    public void login(ActionEvent event) throws IOException {
        System.out.println("Hello");
        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/dashboard.fxml").toURI().toURL();
        URL styleUrl = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/stylesheets/dashboard.css").toURI().toURL();
        Parent HomePage = FXMLLoader.load(url);
        HomePage.getStylesheets().add(String.valueOf(styleUrl));

        Scene HomeScene = new Scene(HomePage);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(HomeScene);
        window.show();
    }
}
