package com.company.parkinglot;


import java.util.*;

public class Floor {

    private List<ParkingSpot> parkingSpots;
    int floorId;

    Floor(int floorId, List<ParkingSpot> parkingSpots){
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public int getParkingSpotCount(){
        return this.parkingSpots.size();
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle){
        SlotType type = ParkingFactory.getParkingSpotType(vehicle.getType());
        for(ParkingSpot ps: parkingSpots){
            if(ps.isAvailable() && (type == ps.getType()) ){ // this logic can change: need to figure out
                System.out.println("Parking spot found for: "+ vehicle.getRegistrationNumber());
                System.out.println("floor: "+ this.floorId + " spot: "+ ps.getId() );
                return ps;
            }
        }


        return null;
    }

    public void getFreeParkingSpotCount(VehicleType vehicle_type){
        SlotType type = ParkingFactory.getParkingSpotType(vehicle_type);
        int count = 0;
        for(ParkingSpot ps: parkingSpots){
            if(ps.isAvailable() && type.equals(ps.getType())){ // this logic can change: need to figure out
               count++;
            }
        }

        System.out.println("\n\nNo. of free slots for " + vehicle_type+ " on Floor "+this.floorId+" : "+ count);

    }

    public void getParkingSpots(VehicleType vehicle_type){
        SlotType type = ParkingFactory.getParkingSpotType(vehicle_type);
        StringBuilder sb = new StringBuilder();

        for(ParkingSpot ps: parkingSpots){
            if(ps.isAvailable() && type.equals(ps.getType())){ // this logic can change: need to figure out
                sb.append(ps.getId());
                sb.append(',');
            }
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }


        System.out.println("\n\nFree slots for " + vehicle_type+ " on Floor "+this.floorId+" : "+ sb.toString());

    }

    public void getOccupiedSpots(VehicleType vehicle_type){
        SlotType type = ParkingFactory.getParkingSpotType(vehicle_type);
        StringBuilder sb = new StringBuilder();

        for(ParkingSpot ps: parkingSpots){
            if(!ps.isAvailable() && type.equals(ps.getType())){ // this logic can change: need to figure out
                sb.append(ps.getId());
                sb.append(',');
            }
        }

        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }

        System.out.println("\n\nOccupied slots for " + vehicle_type+ " on Floor "+this.floorId+" : "+ sb.toString());

    }

}
