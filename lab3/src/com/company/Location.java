package com.company;

import java.util.HashMap;
import java.util.Map;

abstract class Location implements Comparable<Location> {
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public void setCost(Location node, int value){
        cost.put(node,value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo (Location other){
        if(this.name == null) return 0;
        return this.name.compareTo(other.name);
    }
}
