package com.southstar.apappfe.utils;

import com.southstar.apappfe.models.Customer;

public class Driver {
    public static void main(String[] args) {
        Client client = new Client();
        CustomerLogin customerLogin = new CustomerLogin("1901905","sadsdsadas");
        Customer customer = new Customer("1901906","firstname","lastname","email","contacnt");
        client.sendAction("/AddCustomer");
        client.sendCustomer(customer);
        client.receiveResponse();
        client.closeConnection();
//        System.out.println(customerReceived.toString());

    }
}
