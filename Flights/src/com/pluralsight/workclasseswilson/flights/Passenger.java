package com.pluralsight.workclasseswilson.flights;

public class Passenger {
    private int noBags;
    private int noCheckedBags;

    Passenger(){
        this.noBags = 0;
        this.noCheckedBags = 0;
    }

    Passenger(int noBags, int noCheckedBags){
        this.noBags = noBags;
        this.noCheckedBags = noCheckedBags;
    }

    public int getNoBags() {
        return noBags;
    }

    public void setNoBags(int noBags) {
        this.noBags = noBags;
    }

    public int getNoCheckedBags() {
        return noCheckedBags;
    }

    public void setNoCheckedBags(int noCheckedBags) {
        this.noCheckedBags = noCheckedBags;
    }
}
