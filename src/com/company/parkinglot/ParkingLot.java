package com.company.parkinglot;

import java.util.*;

public class ParkingLot {

    static class Pair{
        int floor_num;
        ParkingSpot parkingSpot;

        Pair(int floor_num, ParkingSpot parkingSpot){
            this.floor_num = floor_num;
            this.parkingSpot = parkingSpot;
        }
    }

    private List<Floor> floors;
    private String parkingId;
    private ParkingStrategy parkingStrategy;


    public ParkingLot(String parkingId, List<Floor> floors, ParkingStrategy parkingStrategy){
        this.floors = floors;
        this.parkingId = parkingId;
        this.parkingStrategy = parkingStrategy;

    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }


    public String getParkingId(){
        return this.parkingId;
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    public Floor getFloor(int id){
        return floors.get(id);
    }

    public Pair getAvailableParkingSpot(Vehicle vehicle){
        Pair p = this.parkingStrategy.findParkingSpot(vehicle, floors);
        if(p!=null){
            return p;
        }

        System.out.println("No available parking slot for vehicle: "+ vehicle.getRegistrationNumber());
        return null;

    }



    public void getFreeCount(VehicleType vehicle_type) {

        for (Floor floor : floors) {
            floor.getFreeParkingSpotCount(vehicle_type);

        }
    }

    public void getParkingSpots(VehicleType vehicle_type){

        for (Floor floor : floors) {
            floor.getParkingSpots(vehicle_type);

        }
    }

    public void getOccupiedSpots(VehicleType vehicle_type){
        for (Floor floor : floors) {
            floor.getOccupiedSpots(vehicle_type);

        }
    }





}
