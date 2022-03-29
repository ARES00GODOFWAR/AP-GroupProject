package com.southstar.apappfe.controllers;

import com.southstar.apappfe.utils.CustomerLogin;
import com.southstar.apappfe.utils.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField Id;
    @FXML
    private TextField Password;
    @FXML
    private Text invalidPrompt;

    @FXML
    public void login(ActionEvent event) throws IOException {

        invalidPrompt.setVisible(false);

        String id_holder = Id.getCharacters().toString();
        String password_holder = Password.getCharacters().toString();
         if(!id_holder.isEmpty() && !password_holder.isEmpty()) {
             if(Validator.containsOnlyNumbers(id_holder)) {
                 System.out.println("good");
//                 CustomerLogin customerLogin = new CustomerLogin(id_holder,password_holder);
//                 boolean flag = customerLogin.login(customerLogin);
//                 if(flag){
//                     URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/dashboard.fxml").toURI().toURL();
//                     URL styleUrl = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/stylesheets/dashboard.css").toURI().toURL();
//                     Parent HomePage = FXMLLoader.load(url);
//                     HomePage.getStylesheets().add(String.valueOf(styleUrl));
//                     Scene HomeScene = new Scene(HomePage);
//                     Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//                     window.setScene(HomeScene);
//                     window.show();
                 }



         }else{
             invalidPrompt.setVisible(true);
         }


    }

    public void handleSignUp(ActionEvent actionEvent) {
        System.out.println("Begin sign up");
    }
}
