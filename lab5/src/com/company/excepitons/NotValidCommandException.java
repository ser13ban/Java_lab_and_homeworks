package com.company.excepitons;

public class NotValidCommandException extends Exception{
    public NotValidCommandException(String errorMessage){
        super(errorMessage);
    }
}
