package com.southstar.apappfe.controllers;

import com.southstar.Domain.CustomerComplaint;
import com.southstar.Domain.Employee;
import com.southstar.apappfe.utils.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TechDashboardController implements Initializable {
    @FXML
    private TableView complaintTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<CustomerComplaint,String> idColumn = new TableColumn<>("Customer ID");
        idColumn.setPrefWidth(110.0);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        TableColumn<CustomerComplaint,String> nameColumn = new TableColumn<>("Name");
        nameColumn.setPrefWidth(94.0);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<CustomerComplaint,String> contactColumn = new TableColumn<>("Contact");
        contactColumn.setPrefWidth(81.0);
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<CustomerComplaint,String> issueColumn = new TableColumn<>("Issue Type");
        issueColumn.setPrefWidth(91.0);
        issueColumn.setCellValueFactory(new PropertyValueFactory<>("typeOfIssue"));

        TableColumn<CustomerComplaint,String> detailsColumn = new TableColumn<>("Issue Details");
        detailsColumn.setPrefWidth(282.0);
        detailsColumn.setCellValueFactory(new PropertyValueFactory<>("complaintBody"));

        // idColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Friends","Family","Work Contact"));
        complaintTable.getColumns().addAll(idColumn,nameColumn,contactColumn,issueColumn,detailsColumn);
        complaintTable.setItems(getComplaints());
        complaintTable.setRowFactory(tv -> {
            TableRow<CustomerComplaint> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    CustomerComplaint clickedRow = row.getItem();
//                    try {
//                         editComplaint(clickedRow);
//                        System.out.println("test");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            });
            return row ;
        });

    }

    private void editComplaint(CustomerComplaint clickedRow) {
        System.out.println("test");
    }

    private ObservableList getComplaints() {
        Client client = new Client();
        client.sendAction("/GetComplaintsFor");
        client.sendId(Employee.getCustomerInstance(new Employee()).getStaffID());
        List<CustomerComplaint> customerComplaintList = (List<CustomerComplaint>) client.receiveResponse();
//        System.out.println("Comp id:"+customerComplaintList.get(0).getComplaintID());
//        for (int i = 0; i < customerComplaintList.size(); i++) {
//            System.out.println(customerComplaintList.get(i).toString());
//
//        }
        client.closeConnection();

        return FXCollections.observableArrayList(customerComplaintList);
    }
}
