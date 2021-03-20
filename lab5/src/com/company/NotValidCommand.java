package com.company;

public class NotValidCommand extends Exception{
    public NotValidCommand(String errorMessage){
        super(errorMessage);
    }
}
