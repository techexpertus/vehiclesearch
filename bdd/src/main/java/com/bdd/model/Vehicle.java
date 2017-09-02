package com.bdd.model;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {
    private Map<String, String> details = new HashMap<>();

    public Vehicle(String registrationNumber, String make, String colour) {
        details.put("registrationNumber", registrationNumber);
        details.put("make", make);
        details.put("colour", colour);
    }

    public Vehicle(Map<String,String> details){
        this.details = details;
    }

    public static Vehicle createVehicle(String registrationNumber, String make, String colour) {
        return new Vehicle(registrationNumber, make, colour);
    }
}
