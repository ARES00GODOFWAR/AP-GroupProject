package com.southstar.Domain;

import com.southstar.apappfe.utils.Client;

import java.io.Serial;
import java.io.Serializable;

public class Customer implements Serializable {
    @Serial
    private static  final long serialVersionUID=1;
    private String customerId;
    private String password;
    private String firstname="";
    private String lastname="";
    private String emailAddress="";
    private String contactNumber="";

    public Customer() {
    }

    public Customer(String customerId, String password) {
        this.customerId = customerId;
        this.password = password;
    }

    public Customer(String customerId, String password, String firstname, String lastname, String emailAddress, String contactNumber) {
        this.customerId = customerId;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public Customer login(Customer customer) {
        Client client = new Client();
        client.sendAction("/CustomerLogin");
        client.sendCustomer(customer);
        Customer customerReceived = (Customer) client.receiveResponse();
        client.closeConnection();
        return customerReceived;


    }
}
