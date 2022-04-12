package com.southstar.Domain;

import java.io.Serial;
import java.io.Serializable;
import java.lang.annotation.Repeatable;
import java.util.Date;


public class Complaint implements Serializable {
    @Serial
    private static  final long serialVersionUID=1;

    private int complaintId;
    private String typeOfIssue;
    private String complaintBody;
    private Employee employee;
    private String response;
    private String date;
    private Customer customer;

    public Complaint(String typeOfIssue, String complaintBody,Customer customer) {

        this.typeOfIssue = typeOfIssue;
        this.complaintBody = complaintBody;
        this.customer = customer;
    }

    public Complaint() {

    }

    public String getTypeOfIssue() {
        return typeOfIssue;
    }

    public void setTypeOfIssue(String typeOfIssue) {
        this.typeOfIssue = typeOfIssue;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getComplaintBody() {
        return complaintBody;
    }

    public void setComplaintBody(String complaintBody) {
        this.complaintBody = complaintBody;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", typeOfIssue='" + typeOfIssue + '\'' +
                ", complaintBody='" + complaintBody + '\'' +
                ", customer=" + customer +
                '}';
    }
}

