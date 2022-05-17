package com.pluralsight.workclasseswilson.flights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Flight implements Comparable<Flight>, Iterable<Passenger>{
    private int noPassengers;
    private int seats;
    private String flightNumber;
    private char flightClass;
    private boolean[] isSeatAvailable = new boolean[this.seats];
    private static int allPassengers;
    private int totalCheckedBags;

    private List<Passenger> passengerList = new ArrayList<>();

    //initialization block => all seats initial available
    //code will run automatically no matter what construct is called
    {
        for(int i =0; i < this.seats; i++){
            isSeatAvailable[i] = true;
        }
    }

    public Flight(){}

    public Flight(int passengers, int seats) {
        this.noPassengers = passengers;
        this.seats = seats;
    }

    public Flight(String flightNumber, char flightClass) {
        this.flightNumber = flightNumber;
        this.flightClass = flightClass;
    }

    public int getNoPassengers() {
        return noPassengers;
    }
    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public char getFlightClass() {
        return flightClass;
    }
    public void setFlightClass(char flightClass) {
        this.flightClass = flightClass;
    }
    public boolean[] getIsSeatAvailable() {
        return isSeatAvailable;
    }
    public void setIsSeatAvailable(boolean[] isSeatAvailable) {
        this.isSeatAvailable = isSeatAvailable;
    }
    public static int getAllPassengers() {
        return allPassengers;
    }
    public static void setAllPassengers(int allPassengers) {
        Flight.allPassengers = allPassengers;
    }
    public int getTotalCheckedBags() {
        return totalCheckedBags;
    }
    public void setTotalCheckedBags(int totalCheckedBags) {
        this.totalCheckedBags = totalCheckedBags;
    }

    ///verify if total capacity is enough between 2 flights, SAME airplane
    //al doilea zbor vine ca param
    //!! Need to verify if comparing DIFFERENT flights
    public boolean hasRoom(Flight f2){
        if(this != f2) {
            int total = this.noPassengers + f2.noPassengers;
            return total <= this.seats;
        }else return false;
    }

    public int getAllPassengers(Flight f2) {
        return this.noPassengers + f2.noPassengers;
    }

    private boolean hasSeating(int newPassengers){
        return noPassengers + newPassengers <= seats;
    }

    public void addPassengers(Passenger... list){   //accepting variable nb of params
        if(hasSeating(list.length)){
            noPassengers += list.length;
            for(Passenger passenger : list){
                totalCheckedBags += passenger.getNoCheckedBags();
            }
        }
    }

    @Override
    public int compareTo(Flight o) {
        return 0;
    }

    @Override
    public Iterator<Passenger> iterator() {
        return passengerList.iterator();
    }
    //returns passengers in whatever order were added

    //inner cls => can reference members of big class
    //each instance of FlightIterable => associated w. Flight
    private class FlightIterable implements Iterable<Passenger>{
        @Override
        public Iterator<Passenger> iterator() {

            Passenger[] passengers = new Passenger[passengerList.size()];       //array SIZE based on list in big cls
            passengerList.toArray(passengers); //copy passengers references into array
            Arrays.sort(passengers);            //sort the array after Pass impl Comparable
            return Arrays.asList(passengers).iterator();    //return passengers array in sorted order
        }
    }
}


//objects passed by reference, refernce is copied to the method
//method changes to the reference, not visible outside the method
//method changes to the referenced object, remain visible outside of meth
