package com.company.parkinglot;

import java.util.List;

public class HighestFloorFirstStrategy implements ParkingStrategy {
    @Override
    public ParkingLot.Pair findParkingSpot(Vehicle vehicle, List<Floor> floors) {
        for (int i = floors.size() - 1; i >= 0; i--) {
            Floor floor = floors.get(i);
            ParkingSpot ps = floor.getParkingSpot(vehicle);
            if (ps != null) {
                return new ParkingLot.Pair(floor.floorId, ps);
            }
        }
        return null;
    }
}
