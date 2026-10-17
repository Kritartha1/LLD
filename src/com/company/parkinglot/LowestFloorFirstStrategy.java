package com.company.parkinglot;

import java.util.List;

public class LowestFloorFirstStrategy implements ParkingStrategy{


    @Override
    public ParkingLot.Pair findParkingSpot(Vehicle vehicle, List<Floor> floors) {

        for (Floor floor : floors) {
            ParkingSpot ps = floor.getParkingSpot(vehicle);
            if (ps != null) {
                return new ParkingLot.Pair(floor.floorId, ps);
            }
        }
        return null;
    }
}
