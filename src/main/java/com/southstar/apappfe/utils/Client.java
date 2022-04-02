package com.southstar.apappfe.utils;

import com.southstar.apappfe.models.Customer;
import javafx.scene.layout.BorderPane;

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
            socket = new Socket("127.0.0.1",8080);
            System.out.println("here socket "+ socket);
        }catch (IOException e){
            e.printStackTrace();

        }
    }
    private void configureStreams(){
        try{
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());


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
    public void sendCustomerLoginInfo(CustomerLogin customerLogin){
        try{
            objectOutputStream.writeObject(customerLogin);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
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
                System.out.println("Reacher logined");
               return objectInputStream.readObject();
            }
            if(action.equals("/AddCustomer")){
                System.out.println("Customer added");
                return objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
