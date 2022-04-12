package com.southstar.apappfe.controllers;

import com.southstar.Domain.Complaint;
import com.southstar.Domain.Customer;
import com.southstar.Domain.CustomerComplaint;
import com.southstar.Domain.Employee;
import com.southstar.apappfe.utils.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RepViewComplaintController implements Initializable {
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
    private TextField typeOfIssue;
    @FXML
    private TextArea complaintBody;
    @FXML
    private Pane contentPane;
    @FXML
    private ComboBox assignTo;
    CustomerComplaint complaintHolder;

    private String[] services={"1900000","224214214","124214214214"};
    @FXML
    private void openDashboard(ActionEvent event) throws IOException {

        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/repDashboard.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }
    @FXML
    public void confirm(ActionEvent event) throws IOException {

            if (assignTo.getValue() == null) {
                System.out.println("Cannot submit");
            } else {

                Complaint complaint = new Complaint(complaintHolder.getTypeOfIssue(),complaintHolder.getComplaintBody(),Customer.getCustomerInstance(new Customer()));
                complaint.setComplaintId(complaintHolder.getComplaintID());
                Client client = new Client();
                System.out.println(complaint.getComplaintId());
                client.sendAction("/AssignToEmployee");
                client.sendComplaint(complaint);
                client.sendId(assignTo.getValue().toString());
                client.receiveResponse();
                client.closeConnection();
                URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/repDashboard.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                contentPane.getScene().setRoot(root);
            }
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateField();
        assignTo.setItems(FXCollections.observableArrayList(getEmployeesToAssign()));
        complaintHolder = CustomerComplaint.getCustomerComplaintInstance(new CustomerComplaint());
        System.out.println(complaintHolder.getCustomerID());

    }



    public  void populateField(){
        customerID.setText(Customer.getCustomerInstance(new Customer()).getCustomerId().toUpperCase());
        firstName.setText(Customer.getCustomerInstance(new Customer()).getFirstname().toUpperCase());
        lastName.setText(Customer.getCustomerInstance(new Customer()).getLastname().toUpperCase());
        emailAddress.setText(Customer.getCustomerInstance(new Customer()).getEmailAddress().toUpperCase());
        contactNumber.setText(Customer.getCustomerInstance(new Customer()).getContactNumber().toUpperCase());
        typeOfIssue.setText(CustomerComplaint.getCustomerComplaintInstance(new CustomerComplaint()).getTypeOfIssue());
        complaintBody.setText(CustomerComplaint.getCustomerComplaintInstance(new CustomerComplaint()).getComplaintBody());


    }
    public List<String> getEmployeesToAssign(){
        Client client = new Client();
        List<String> options = new ArrayList<>();
        client.sendAction("/GetTechnicians");
        List<Employee> employees = (List<Employee>) client.receiveResponse();
        for (int i = 0; i < employees.size(); i++) {
            options.add(employees.get(i).getStaffID());

        }
        client.closeConnection();
        return options;
    }
}
