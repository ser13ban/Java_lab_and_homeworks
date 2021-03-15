package com.company;

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
