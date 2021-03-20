package com.company;

public class NotValidCommandException extends Exception{
    public NotValidCommandException(String errorMessage){
        super(errorMessage);
    }
}
