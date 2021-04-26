package com.company;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List friends = new ArrayList<String>();

    public User(String name){
        this.name = name;
        this.friends = new ArrayList<String>();
    }
}
