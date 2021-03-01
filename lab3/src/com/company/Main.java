package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Hotel v1 = new Hotel();
        v1.setName("Victoria");
        Museum v2 = new Museum();
        v2.setName("A");
        Museum v3 = new Museum();
        v3.setName("B");
        Church v4 = new Church();
        v4.setName("A");
        Church v5 = new Church();
        v5.setName("B");
        Restaurant v6 = new Restaurant();

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

    }
}
