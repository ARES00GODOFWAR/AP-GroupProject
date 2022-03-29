package com.southstar.apappfe.utils;

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
    public void sendCustomerLoginInfo(CustomerLogin customerLogin){
        try{
            objectOutputStream.writeObject(customerLogin);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Object receiveResponse(){
        try{
            if(action.equalsIgnoreCase("/CustomerLogin")){
               return objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
