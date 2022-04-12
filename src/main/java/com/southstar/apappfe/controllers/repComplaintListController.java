package com.southstar.apappfe.controllers;

import com.southstar.Domain.Customer;
import com.southstar.Domain.CustomerComplaint;
import com.southstar.apappfe.utils.Client;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class repComplaintListController implements Initializable {
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
        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/repDashboard.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<CustomerComplaint,String> bodyColumn = new TableColumn<>("Complaints");
        bodyColumn.setPrefWidth(341.5999755859375);
        bodyColumn.setCellValueFactory(new PropertyValueFactory<>("complaintBody"));

        TableColumn<CustomerComplaint,String> typeColumn = new TableColumn<>("Service Type");
        typeColumn.setPrefWidth(154.39996337890625);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfIssue"));

        TableColumn<CustomerComplaint,String> idColumn = new TableColumn<>("Assign To");
        idColumn.setPrefWidth(159.39996337890625);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
       // idColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Friends","Family","Work Contact"));
        complaintTable.getColumns().addAll(bodyColumn,typeColumn,idColumn);
        complaintTable.setItems(getComplaints());
        complaintTable.setRowFactory(tv -> {
            TableRow<CustomerComplaint> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    CustomerComplaint clickedRow = row.getItem();
                    try {
                        editComplaint(clickedRow);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row ;
        });

// ...


    }

    private void editComplaint(CustomerComplaint clickedRow) throws IOException {

        Client client = new Client();
        client.sendAction("/GetCustomer");
        client.sendId(clickedRow.getCustomerID());
        Customer customer = Customer.setNewInstance((Customer) client.receiveResponse());
        client.closeConnection();
        System.out.println(clickedRow.getCustomerID());
        CustomerComplaint customerComplaint =CustomerComplaint.setNewInstance(clickedRow);
        System.out.println(customerComplaint.getCustomerID());
        System.out.println(clickedRow.getComplaintBody());
        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfeRep/repViewComplaint.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        contentPane.getScene().setRoot(root);
    }

    private ObservableList getComplaints() {
        Client client = new Client();
        client.sendAction("/GetComplaints");

        List<CustomerComplaint> customerComplaintList = (List<CustomerComplaint>) client.receiveResponse();
        System.out.println("Comp id:"+customerComplaintList.get(0).getComplaintID());
        for (int i = 0; i < customerComplaintList.size(); i++) {
            System.out.println(customerComplaintList.get(i).toString());

        }
        client.closeConnection();

        return FXCollections.observableArrayList(customerComplaintList);
    }

//    @FXML
//    private void openPayments(ActionEvent event) throws IOException {
//
//        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/listOfPayments.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(url);
//        contentPane.getScene().setRoot(root);
//    }
//    @FXML
//    private void makeComplaints(ActionEvent event) throws IOException {
//        URL url = new File("src/main/java/com/southstar/apappfe/fxml/resources/com/southstar/apappfe/repViewComplaint.fxml").toURI().toURL();
//        Parent root = FXMLLoader.load(url);
//        makeComplaintButton.arm();
//        PauseTransition pause = new PauseTransition(Duration.seconds(1));
//        pause.setOnFinished(e -> {
//                    makeComplaintButton.disarm();
//                   // makeComplaintButton.fire();
//                }
//        );
//        pause.play();
//        contentPane.getScene().setRoot(root);
//    }
}
