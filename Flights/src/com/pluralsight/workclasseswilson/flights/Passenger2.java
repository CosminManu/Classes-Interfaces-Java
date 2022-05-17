package com.pluralsight.workclasseswilson.flights;

public class Passenger2 implements Comparable<Passenger2>{
    private String name;
    private int memberLevel;    //primary order detail
    private int memberDays;     //secondary order detail

    public Passenger2(String name, int memberLevel, int memberDays) {
        this.name = name;
        this.memberLevel = memberLevel;
        this.memberDays = memberDays;
    }

    @Override
    public int compareTo(Passenger2 o) {
        int compareValue = o.memberLevel - this.memberLevel;
        if(compareValue == 0){
            compareValue = o.memberDays - this.memberDays;
        }
        return compareValue;
    }
}
