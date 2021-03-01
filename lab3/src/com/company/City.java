package com.company;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Location> nodes;

    public City(){
        nodes  = new ArrayList<>();
    }

    public void addLocation(Location node){
        nodes.add(node);
    }

    public static interface Classifiable {
        int getRank();
    }
}
