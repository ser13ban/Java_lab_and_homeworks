package com.company;

public class Factory extends Source{
    public  Factory(String name, int supply) {
        this.setSupply(supply);
        this.setName(name);
    }
}
