package com.southstar.apappfe.controllers;

import com.southstar.Domain.Customer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


import java.io.File;
import java.io.IOException;
import java.net.URL;
public class MakeComplaintController {


    @FXML
    public TextField firstName;
    @FXML
    private TextField customerID;
    @FXML
    private TextField lastName;
    @FXML
    private TextField contactNumber;
    @FXML
    private TextField emailAddress;
    @FXML
    private ComboBox<String> typeOfService;

    private String[] services={"Technical Issue","Hardware Issue","Other Issues"};



    @FXML
    private Pane contentPane;
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
    public void initialize(){
        populateField();
        //customerID.setText(Customer.getCustomerInstance(new Customer()).getCustomerId());

    }

    public  void populateField(){
        customerID.setText(Customer.getCustomerInstance(new Customer()).getCustomerId().toUpperCase());
        firstName.setText(Customer.getCustomerInstance(new Customer()).getFirstname().toUpperCase());
        lastName.setText(Customer.getCustomerInstance(new Customer()).getLastname().toUpperCase());
        emailAddress.setText(Customer.getCustomerInstance(new Customer()).getEmailAddress().toUpperCase());
        contactNumber.setText(Customer.getCustomerInstance(new Customer()).getContactNumber().toUpperCase());
        typeOfService.setItems(FXCollections.observableArrayList(services));




        ///customerID.
//        MakeComplaintController makeComplaintController = new MakeComplaintController();
//       makeComplaintController.customerID.setText(Customer.getCustomerInstance(new Customer()).getCustomerId());

    }
}
