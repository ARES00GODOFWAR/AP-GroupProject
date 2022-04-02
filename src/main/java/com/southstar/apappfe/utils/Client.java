package com.southstar.apappfe.utils;

import com.southstar.Domain.Customer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
            e.printStackTrace();

        }
    }
    private void configureStreams(){
        try{
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try{
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void sendAction(String action){
        this.action = action;
        try{
            objectOutputStream.writeObject(action);
        }catch (IOException e){
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
            e.printStackTrace();
        }
    }
    public Object receiveResponse(){
        try{
            if(action.equals("/CustomerLogin")){
                //add a check here to see
               // System.out.println("Customer successfully logged in....");
               return objectInputStream.readObject();
            }
            if(action.equals("/AddCustomer")){
                Boolean flag = (Boolean) objectInputStream.readObject();
                if(flag){
                    System.out.println("Customer added to the database.....");
                }else{
                    System.out.println("Customer failed to be added to the database....");
                }

                return objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
