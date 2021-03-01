package com.company;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable{

    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return getOpeningTime();
    }



    @Override
    public LocalTime getClosingTime() {
        return getClosingTime();
    }

    ///Setere
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

}
