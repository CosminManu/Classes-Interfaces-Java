package com.pluralsight.workclasseswilson.flights;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Flight f1 = new Flight(100,120);
        Flight f2 = new Flight(70,120);
        Flight f3 = new Flight(90,300);
        Flight f4 = new Flight(150,300);
        Flight f5 = new Flight("ob101", 'B');
        Passenger mircea = new Passenger(2, 2);
        Passenger vito = new Passenger(3, 0);
        Passenger burke = new Passenger(8, 2);
        Passenger lincoln = new Passenger(0, 0);

        f5.addPassengers(mircea);
        f5.addPassengers(vito, burke, lincoln);

        if(f1.hasRoom(f2)){
            System.out.println("Enough seats in airplane");
        }else System.out.println("Not enough seats, capacity: " + f1.getSeats() + " passengers: "+f1.getAllPassengers(f2) );

        if(f4.hasRoom(f4)){
            System.out.println("Enough seats in airplane");
        }else System.out.println("Error");

        if(f4.hasRoom(f3)){
            System.out.println("Enough seats in airplane, capacity: "+ f3.getSeats() + " passengers: "+f4.getAllPassengers(f3));
        }else System.out.println("Not enough seats, capacity: " + f3.getSeats() + " passengers: "+f4.getAllPassengers(f3)  );

        swapFlightReference(f1, f4);
        System.out.println(f1.getNoPassengers());
        System.out.println(f4.getNoPassengers());

        swapFlightNumber(f1, f4);
        System.out.println(f1.getNoPassengers());
        System.out.println(f4.getNoPassengers());


        Passenger2[] airbus113 = {
                new Passenger2("Serbanoiu", 1, 140),
                new Passenger2("Dragomir", 1, 80),
                new Passenger2("Stefanescu", 2, 20),
                new Passenger2("Matei", 3, 40)
        };
        Arrays.sort(airbus113);     //utiilizes Comparable interface

    }


    //only changes at copies of params
    //pass by ref
    public static void swapFlightReference(Flight i, Flight j) {
        Flight k = i;
        i = j;
        j = k;
    }
    public static void swapFlightNumber(Flight i, Flight j) {
        int k = i.getNoPassengers();
        i.setNoPassengers((j.getNoPassengers()));
        j.setNoPassengers(k);
    }
}
