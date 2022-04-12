package com.southstar.apappfe.controllers;

import com.southstar.Domain.Complaint;
import com.southstar.Domain.Customer;
import com.southstar.apappfe.utils.Client;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MakeComplaintController implements Initializable {


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
    @FXML
    private TextArea complaintBody;
    @FXML
    private Label errorField;

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
    public void submitComplaint(ActionEvent event) throws IOException {
        if (complaintBody.getText().isEmpty()) {
            errorField.setText("Body cannot be empty.");
        } else {
            errorField.setText("");
            String serviceType = typeOfService.getValue() != null ? typeOfService.getValue() : "Technical Issue";
            Complaint complaint = new Complaint( serviceType, complaintBody.getText(),Customer.getCustomerInstance(new Customer()));
            Client client = new Client();
            client.sendAction("/AddComplaint");
            client.sendComplaint(complaint);
            boolean wasSuccess = (boolean) client.receiveResponse();
            client.closeConnection();
            if(wasSuccess) {
                complaintBody.setText("");
            }else
            {
                errorField.setText("Something went wrong. Please try again later.");
            }


        }
    }
    @FXML
    private void openPayments(ActionEvent event) throws IOException {

        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/listOfPayments.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }


    public  void populateField(){
        customerID.setText(Customer.getCustomerInstance(new Customer()).getCustomerId().toUpperCase());
        firstName.setText(Customer.getCustomerInstance(new Customer()).getFirstname().toUpperCase());
        lastName.setText(Customer.getCustomerInstance(new Customer()).getLastname().toUpperCase());
        emailAddress.setText(Customer.getCustomerInstance(new Customer()).getEmailAddress().toUpperCase());
        contactNumber.setText(Customer.getCustomerInstance(new Customer()).getContactNumber().toUpperCase());
        typeOfService.setItems(FXCollections.observableArrayList(services));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateField();
    }
}
