package com.southstar.apappfe.utils;

import com.southstar.Domain.Customer;

public class Driver {
    public static void main(String[] args) {
        Client client = new Client();
        Customer customer = new Customer("1901905","sadsdsadas");
     //   Customer customer = new Customer("1901906","password","firstname","lastname","email","contact");
        client.sendAction("/CustomerLogin");
        client.sendCustomer(customer);
        Customer customerReceived = (Customer) client.receiveResponse();
        client.closeConnection();
       System.out.println(customerReceived.toString());

    }
}
