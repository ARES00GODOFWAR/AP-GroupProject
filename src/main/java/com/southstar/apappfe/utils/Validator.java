package com.southstar.apappfe.utils;



public class Validator {

    public static boolean containsOnlyNumbers(String text){
        return text.matches("^[0-9]*$");

    }
}
