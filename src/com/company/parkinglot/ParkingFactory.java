package com.company.parkinglot;

public class ParkingFactory {

    static SlotType getParkingSpotType(VehicleType vehicle_type){
        switch (vehicle_type){
            case BIKE:
                return SlotType.SMALL;
            case CAR:
                return SlotType.MEDIUM;
            case TRUCK:
                return SlotType.LARGE;
            default:
                return SlotType.UNDEFINED;
        }

    }


}
