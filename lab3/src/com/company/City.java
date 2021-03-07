package com.company;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
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

    public void displayVisitableWithoutPayingFee(){
        List<Location> locations = new ArrayList<>();
        for (Location i: nodes
             ) {
            if(i instanceof Visitable && !(i instanceof Payable)){
                locations.add(i);
            }
        }

        Collections.sort(locations);
        for (Location i : locations
             ) {
            System.out.println(i.getName());
        }
    }

    public List<Location> getNodes() {
        return nodes;
    }
}
