package com.company;

import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Payable, Classifiable{

    private int rank;
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
