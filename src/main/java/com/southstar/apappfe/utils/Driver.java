package com.southstar.apappfe.utils;

import com.southstar.Domain.Customer;
import com.southstar.Domain.CustomerComplaint;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Client client = new Client();
     //   Customer customer = new Customer("1901905","sadsdsadas");
        Customer customer = new Customer("1901907","password","firstname","lastname","email","contact");
        //client.sendAction("/CustomerLogin");
        client.sendAction("/AddCustomer");
        client.sendCustomer(customer);
        client.receiveResponse();
       // List<CustomerComplaint> customerComplaintList = (List<CustomerComplaint>) client.receiveResponse();
       // System.out.println( customerComplaintList.get(0).getComplaintBody());
       // System.out.println(complaintHolder);
        client.closeConnection();
                //=customer.getComplaints(customer);
//        for (int c = 0; c < complaintHolder.size(); c++) {
//            System.out.println(complaintHolder.get(c).toString());
//
//        }


//        client.sendAction("/GetCustomerComplaint");
//        client.sendCustomer(customer);
//        ComplaintHolder complaintHolder = (ComplaintHolder) client.receiveResponse();
//        client.closeConnection();
       // System.out.println(complaintHolder.getComplaints().toString());

    }
}
