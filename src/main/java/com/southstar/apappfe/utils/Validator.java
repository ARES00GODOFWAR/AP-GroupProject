package com.southstar.apappfe.utils;


import com.southstar.Domain.Employee;

public class Validator {

    public static boolean containsOnlyNumbers(String text){
        return text.matches("^[0-9]*$");

    }
    public static void loginValidator(Object object){
        boolean b = object instanceof Employee;
       // if (b)
    }
    public static String determineUser (int id){
        int firstDigit = Integer.parseInt(Integer.toString(id).substring(0, 1));
        if(firstDigit==1)return "Customer";
        if(firstDigit==3)return "Technician";
        return "Employee";

    }
}
