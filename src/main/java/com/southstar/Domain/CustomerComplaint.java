package com.southstar.Domain;

import javafx.scene.control.ComboBox;

import java.io.Serial;
import java.io.Serializable;

public class CustomerComplaint implements Serializable {
    @Serial
    private static  final long serialVersionUID=1;
    private static CustomerComplaint customerComplaintInstance =null;
    private int complaintID;
    private String typeOfIssue;
    private String complaintBody;
    private String employeeID;
    private String date;
    private String response;
    private String customerID;
    private String contact;
    private String name;


    public CustomerComplaint() {
    }

    public CustomerComplaint(String typeOfIssue, String complaintBody, String employeeID, String date, String response,String customerID,int complaintId,String name,String contact) {
        this.typeOfIssue = typeOfIssue;
        this.complaintBody = complaintBody;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.date = date;
        this.response = response;
        this.complaintID = complaintId;
        this.name = name;
        this.contact = contact;
    }
    public CustomerComplaint(String typeOfIssue, String complaintBody,String customerID,int complaintID) {
        this.typeOfIssue = typeOfIssue;
        this.complaintBody = complaintBody;
        this.customerID = customerID;
        this.employeeID = "";
        this.date = "";
        this.response ="";
        this.complaintID=complaintID;
        this.name = "";
        this.contact = "";

    }

    public String getTypeOfIssue() {
        return typeOfIssue;
    }

    public void setTypeOfIssue(String typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
    }

    public String getComplaintBody() {
        return complaintBody;
    }

    public void setComplaintBody(String complaintBody) {
        this.complaintBody = complaintBody;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintId) {
        this.complaintID = complaintId;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CustomerComplaint getCustomerComplaintInstance(CustomerComplaint customerComplaint) {
        if(customerComplaintInstance==null){
            customerComplaintInstance = customerComplaint;
        }
        return customerComplaintInstance;
    }
    public static CustomerComplaint setNewInstance(CustomerComplaint customerComplaint){
        customerComplaintInstance =customerComplaint;
        return customerComplaintInstance;

    }

    @Override
    public String toString() {
        return "CustomerComplaint{" +
                "complaintId='" + complaintID + '\'' +
                ", typeOfIssue='" + typeOfIssue + '\'' +
                ", complaintBody='" + complaintBody + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", date='" + date + '\'' +
                ", response='" + response + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
