package com.southstar.apappfe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage=primaryStage;
        primaryStage.setResizable(false);
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        root.getStylesheets().add(getClass().getResource("stylesheets/login.css").toExternalForm());
        primaryStage.setTitle("MicroStarCable");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();

//        stage=primaryStage;
//        primaryStage.setResizable(false);
//        Parent root;
//        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/login.fxml").toURI().toURL();
//        root = FXMLLoader.load(url);
//        URL urlStyleSheet = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/stylesheets/login.css").toURI().toURL();
//
//        root.getStylesheets().add(Objects.requireNonNull(getClass().getResource(url.toString())).toExternalForm());
//        primaryStage.setTitle("MicroStarCable");
//        primaryStage.setScene(new Scene(root,600,400));
//        primaryStage.show();
//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
//        root.getStylesheets().add(getClass().getResource("stylesheets/login.css").toExternalForm());
//        primaryStage.setTitle("MicroStarCable");
//        primaryStage.setScene(new Scene(root,600,400));
//        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.getScene().setRoot(pane);

    }
    public static void main(String[] args) {
        launch();
    }
}