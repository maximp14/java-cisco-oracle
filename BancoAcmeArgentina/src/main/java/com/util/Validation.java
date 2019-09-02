package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean phoneValidation(String number){
        Pattern pattern = Pattern.compile("^[0][1-9]{2,3}-[0-9]{6,8}$");
        Matcher matcher = pattern.matcher(number);
        Pattern pattern1 = Pattern.compile("^[0][1-9]{2,3}-[15]{2}\\d{6,8}$");
        Matcher matcher1 = pattern1.matcher(number);
        if (matcher.find() || matcher1.find()){
            return true;
        }else {
            return false;
        }
    }

    public static boolean emailValidation(String email){
        Pattern pattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            return true;
        }else{
            return false;
        }
    }

}
