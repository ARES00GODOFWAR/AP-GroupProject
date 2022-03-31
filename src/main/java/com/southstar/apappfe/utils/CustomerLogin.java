package com.southstar.apappfe.utils;

import com.southstar.apappfe.models.Customer;

import java.io.Serial;
import java.io.Serializable;

public class CustomerLogin implements Serializable {
    @Serial
    private static  final long serialVersionUID=1;
    private String id;
    private String password;

    public CustomerLogin(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer login(CustomerLogin customerLogin) {
        Client client = new Client();
        client.sendAction("/CustomerLogin");
        client.sendCustomerLoginInfo(customerLogin);
        Customer customer = (Customer) client.receiveResponse();
        client.closeConnection();
        return customer;


    }

    @Override
    public String toString() {
        return "CustomerLogin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
