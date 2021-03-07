package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelPlan {
    private City c;
    private List<Integer> preferences;
    Scanner scan = new Scanner(System.in);

    public TravelPlan(City c) {
        this.c = c;
        this.preferences = new ArrayList<Integer>();
        for (Location i: c.getNodes()
             ) {
            System.out.println("Introduceti ordinea preferintei pentru locatia: " + i.getName());
            this.preferences.add(scan.nextInt());
            System.out.println();
        }
    }

    public City getC() {
        return c;
    }

    public void setC(City c) {
        this.c = c;
    }

    public List<Integer> getPreferences() {
        return preferences;
    }

    public Location getMinPreference(Location l){
        int min = 100000;
        Location minL = null;
        for (Location i : c.getNodes()
             ) {
            if(l.getCost().get(i) != null){
                if(preferences.get(c.getNodes().indexOf(i) )  < min && preferences.get(c.getNodes().indexOf(i)) > -1){
                    min = preferences.get(c.getNodes().indexOf(i) );
                    minL = i;
                }
            }
        }
        System.out.println(minL.getName());
        preferences.set(c.getNodes().indexOf(minL),-1);
        return minL;
    }
    public void solve(Location start, Location end){
        if (start == end)
            System.exit(0);
        else {
            start  = getMinPreference(start);
            solve(start ,end);
        }

    }
}
