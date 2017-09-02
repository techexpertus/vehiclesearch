package com.bdd.model;

public class Vehicle {
    private String registrationNumber;
    private String make;
    private String color;

    public Vehicle(String registrationNumber, String make, String color) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.color = color;
    }

    public  static Vehicle createVehicle(String registrationNumber, String make, String color){
        return new Vehicle(registrationNumber,make,color);
    }
}
