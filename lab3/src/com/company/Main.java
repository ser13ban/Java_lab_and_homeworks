package com.company;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Hotel v1 = new Hotel();
        v1.setName("Hotel Unirea");
        Museum v2 = new Museum();
        /*v2.setOpeningTime(LocalTime.of(9,30,0));
        v2.setClosingTime(LocalTime.of(20,0,0));*/
        v2.setName("Muzeul A");
        Museum v3 = new Museum();
        v3.setName("Muzeul B");
        Church v4 = new Church();
        v4.setName("Biserica A");
        Church v5 = new Church();
        v5.setName("Biserica B");
        Restaurant v6 = new Restaurant();
        v6.setName("Restaurant A");

        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,10);
        v3.setCost(v4,20);
        v3.setCost(v2,20);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,30);
        v5.setCost(v6,20);

        City c = new City();
        c.addLocation(v1);
        c.addLocation(v2);
        c.addLocation(v3);
        c.addLocation(v4);
        c.addLocation(v5);
        c.addLocation(v6);

        //c.displayVisitableWithoutPayingFee();
        //System.out.println(Visitable.getVisitingDuration(v2.getOpeningTime(),v2.getClosingTime()));

        TravelPlan t = new TravelPlan(c);
        t.solve(v1,v4);
    }
}
