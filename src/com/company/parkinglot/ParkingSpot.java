package com.company.parkinglot;

public class ParkingSpot
{
    private int id;
    private Vehicle vehicle;
    private SlotType type;

    ParkingSpot(int id, String type){
        this.id = id;
        this.type = SlotType.valueOf(type);
    }

    public int getId(){
        return this.id;
    }

    public SlotType getType(){
        return this.type;
    }

    public ParkingSpot fillParkingSpot(Vehicle vehicle){

        this.vehicle = vehicle;
        return this;
    }

    public void clearParkingSpot(){
        this.vehicle = null;
    }


    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public boolean isAvailable(){
        return this.vehicle == null;
    }
}
