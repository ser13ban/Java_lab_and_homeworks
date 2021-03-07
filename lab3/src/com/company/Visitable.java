package com.company;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.HOURS;

public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    void setOpeningTime(LocalTime openingTime);
    void setClosingTime(LocalTime closingTime);
    default void setTimes(){
        this.setOpeningTime(LocalTime.of(9,30,0));
        this.setClosingTime(LocalTime.of(20,0,0));
    }
    static long  getVisitingDuration(LocalTime open, LocalTime closing){
        return HOURS.between(open,closing);
    }
}
