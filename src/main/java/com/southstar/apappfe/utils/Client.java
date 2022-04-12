package com.southstar.apappfe.utils;

import com.southstar.Domain.Complaint;
import com.southstar.Domain.Customer;
import com.southstar.Domain.CustomerComplaint;
import com.southstar.Domain.Employee;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {


    private ObjectInputStream objectInputStream;
    private static ObjectOutputStream objectOutputStream;
    private Socket socket;
    private String action="";

    public Client() {
        this.createConnection();
        this.configureStreams();



    }
    private void createConnection(){
        try{
            socket = new Socket("127.0.0.1",2000);

        }catch (IOException e){
            Log.logger.error(e);
            e.printStackTrace();

        }
    }
    private void configureStreams(){
        try{
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        }catch(IOException e){
            Log.logger.error(e);
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }catch (IOException e){
            Log.logger.error(e);
            e.printStackTrace();
        }
    }
    public void sendAction(String action){
        this.action = action;
        try{
            objectOutputStream.writeObject(action);
        }catch (IOException e){
            Log.logger.error(e);
            e.printStackTrace();
        }

    }
    public void sendComplaint(Complaint complaint){
        try {
            objectOutputStream.writeObject(complaint);
        } catch (IOException e) {
            Log.logger.error(e);

            e.printStackTrace();
        }
    }
    public void sendId(String id){
        try {
            objectOutputStream.writeObject(id);
        } catch (IOException e) {
            Log.logger.error(e);

            e.printStackTrace();
        }

    }
//    public void sendCustomerLoginInfo(Customer customer){
//        try{
//            objectOutputStream.writeObject(customer);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    public void sendCustomer(Customer customer){
        try {
            objectOutputStream.writeObject(customer);
        } catch (IOException e) {
            Log.logger.error(e);
           e.printStackTrace();
        }
    }
    public void sendEmployee(Employee employee){
        try {
            objectOutputStream.writeObject(employee);
        } catch (IOException e) {
            Log.logger.error(e);
            e.printStackTrace();
        }
    }
    public Object receiveResponse(){
        try{
            //one login with just the object
            if(action.equals("/CustomerLogin")){
                //add a check here to see
               // System.out.println("Customer successfully logged in....");
               return objectInputStream.readObject();
            }
            if(action.equals("/AddCustomer")){
                Boolean flag = (Boolean) objectInputStream.readObject();
                if(flag){
                    Log.logger.info("Customer added to the database.....");
                }else{
                    Log.logger.error("Customer failed to be added to the database....");
                }

                return objectInputStream.readObject();
            }
            if(action.equals("/EmployeeLogin")){
                return objectInputStream.readObject();
            }
            if(action.equals("/AddComplaint")){
                return (boolean) objectInputStream.readObject();
            }
            if(action.equals("/GetCustomerComplaint")){
                return objectInputStream.readObject();
            }
            if(action.equals("/GetComplaints")){
                 List<CustomerComplaint> test = (List<CustomerComplaint>) objectInputStream.readObject();
                for (int i = 0; i < test.size(); i++) {
                    System.out.println(test.get(i).toString());

                }

                 return test;
            }
            if(action.equals("/GetComplaintsFor")){
                return objectInputStream.readObject();
            }
            if(action.equals("/GetCustomer")){
                return objectInputStream.readObject();
            }
            if(action.equals("/GetTechnicians")){
                return objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {

            Log.logger.error(e);
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
