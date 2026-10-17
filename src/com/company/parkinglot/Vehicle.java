package com.company.parkinglot;

public class Vehicle {



    private String registrationNumber;
    private String color;
    private VehicleType type;

    Vehicle(String registrationNumber, String color, String type){
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.type = VehicleType.valueOf(type);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return this.type;
    }



}
