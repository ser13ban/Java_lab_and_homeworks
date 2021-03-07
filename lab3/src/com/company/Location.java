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
        if( this instanceof  Visitable && other instanceof Visitable){
            if (((Visitable) this).getOpeningTime() != null && ((Visitable) other).getOpeningTime() != null){
                return ((Visitable) this).getOpeningTime().compareTo(((Visitable) other).getClosingTime());
            }else
            {
                System.out.println("NULL instace");
                return 0;
            }
        }
        return 0;
    }
}
