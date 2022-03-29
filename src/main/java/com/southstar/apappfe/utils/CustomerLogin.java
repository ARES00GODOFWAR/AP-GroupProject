package com.southstar.apappfe.utils;

public class CustomerLogin {

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

    public boolean login(CustomerLogin customerLogin) {
        Client client = new Client();
        client.sendAction("/CustomerLogin");
        client.sendCustomerLoginInfo(customerLogin);
        Boolean loginFlag = (Boolean) client.receiveResponse();
        client.closeConnection();
        return loginFlag;

    }
}
