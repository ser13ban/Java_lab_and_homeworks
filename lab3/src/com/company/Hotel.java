package com.company;

public class Hotel extends Location implements Payable, Classifiable{
    private int rank;
    private double ticketPrice;

    public Hotel(){}

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
