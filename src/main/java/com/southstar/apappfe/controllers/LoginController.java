package com.southstar.apappfe.controllers;

import com.southstar.Domain.Customer;
import com.southstar.Domain.Employee;
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
        Customer customer;
        Employee employee;
        URL url;
        URL styleUrl;
         if(!id_holder.isEmpty() && !password_holder.isEmpty()) {

             boolean isIdValid = Validator.containsOnlyNumbers(id_holder);
             String userType = isIdValid? Validator.determineUser(Integer.parseInt(id_holder)):"";
             if(isIdValid && !userType.isEmpty()){
                 if(userType.equalsIgnoreCase("Customer")){
                     customer=  Customer.getCustomerInstance(new Customer(id_holder,password_holder));
                     customer= customer.login(customer);
                     url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/dashboard.fxml").toURI().toURL();
                     styleUrl = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/stylesheets/dashboard.css").toURI().toURL();

                 }else if(userType.equalsIgnoreCase("Employee")){
                     employee = Employee.getCustomerInstance(new Employee(id_holder,password_holder));
                     employee = employee.login(employee);
                     url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/repDashboard.fxml").toURI().toURL();
                     styleUrl = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/stylesheets/dashboard.css").toURI().toURL();

                 }else if(userType.equalsIgnoreCase("Technician")) {
                     employee = Employee.getCustomerInstance(new Employee(id_holder,password_holder));
                     employee = employee.login(employee);
                     url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeTech/techDashboard.fxml").toURI().toURL();
                     styleUrl = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappTech/stylesheets/dashboard.css").toURI().toURL();

                 }else{
                     invalidPrompt.setVisible(true);
                     return;

                 }
                 Parent HomePage = FXMLLoader.load(url);
                 HomePage.getStylesheets().add(String.valueOf(styleUrl));
                 Scene HomeScene = new Scene(HomePage);
                 Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                 window.setScene(HomeScene);
                 window.show();

             }else { invalidPrompt.setVisible(true);}

         }else{
             invalidPrompt.setVisible(true);
         }


    }

    public void handleSignUp(ActionEvent actionEvent) {
        System.out.println("Begin sign up");
    }
}
