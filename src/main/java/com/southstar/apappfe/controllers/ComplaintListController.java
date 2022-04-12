package com.southstar.apappfe.controllers;

import com.southstar.Domain.Customer;
import com.southstar.Domain.CustomerComplaint;
import com.southstar.apappfe.utils.Client;
import javafx.animation.PauseTransition;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ComplaintListController implements Initializable {
    @FXML
    private Button dBtn;

    @FXML
    private Pane contentPane;

    @FXML
    private Button makeComplaintButton;
    @FXML
    private TableView complaintTable;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       TableColumn<CustomerComplaint,String> bodyColumn = new TableColumn<>("Complaint");
       bodyColumn.setPrefWidth(341.5999755859375);
       bodyColumn.setCellValueFactory(new PropertyValueFactory<>("complaintBody"));

        TableColumn<CustomerComplaint,String> typeColumn = new TableColumn<>("Type of Issue");
        typeColumn.setPrefWidth(154.39996337890625);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfIssue"));

        TableColumn<CustomerComplaint,String> idColumn = new TableColumn<>("ID");
        idColumn.setPrefWidth(100.39996337890625);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        TableColumn<CustomerComplaint,String> dateColumn = new TableColumn<>("Date");
       dateColumn.setPrefWidth(154.39996337890625);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<CustomerComplaint,String> responseColumn = new TableColumn<>("Response");
        responseColumn.setPrefWidth(341.5999755859375);
        responseColumn.setCellValueFactory(new PropertyValueFactory<>("response"));

        complaintTable.getColumns().addAll(bodyColumn,typeColumn,idColumn,dateColumn,responseColumn);
        complaintTable.setItems(getComplaints());

    }
    public ObservableList<CustomerComplaint>getComplaints(){
        Client client = new Client();
        client.sendAction("/GetCustomerComplaint");
        client.sendCustomer(Customer.getCustomerInstance(new Customer()));
        List<CustomerComplaint> customerComplaintList = (List<CustomerComplaint>) client.receiveResponse();
        client.closeConnection();

        return FXCollections.observableArrayList(customerComplaintList);
    }
}
