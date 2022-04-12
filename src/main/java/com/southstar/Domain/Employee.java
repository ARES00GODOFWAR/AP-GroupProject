package com.southstar.Domain;

import com.southstar.apappfe.utils.Client;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    @Serial
    private static  final long serialVersionUID=1;
    private String staffID;
    private String password;
    private String employeeType;
    private static Employee employeeInstance=null;

    public Employee() {
    }

    public Employee(Employee employee) {
        employeeInstance = employee;
    }

    public Employee(String staffID, String password) {
        this.staffID = staffID;
        this.password = password;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public static Employee getCustomerInstance(Employee employee) {
        if(employeeInstance==null){
            employeeInstance=employee;
        }
        return employeeInstance;
    }
    public static Employee setNewInstance(Employee employee){
        employeeInstance =employee;
        return employeeInstance;

    }
    public Employee login(Employee employee) {
        Client client = new Client();
        client.sendAction("/EmployeeLogin");
        client.sendEmployee(employee);
        Employee employeeReceived = (Employee) client.receiveResponse();
        client.closeConnection();
        employeeInstance = employeeReceived;
        return employeeReceived;


    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffID='" + staffID + '\'' +
                ", password='" + password + '\'' +
                ", employeeType='" + employeeType + '\'' +
                '}';
    }
}
