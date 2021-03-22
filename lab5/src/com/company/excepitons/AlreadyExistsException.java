package com.company.excepitons;

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
