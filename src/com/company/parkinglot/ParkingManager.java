package com.company.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ParkingManager {

    private List<ParkingLot> parkingLotList;
    private Map<String, ParkingTicket> parkingTicketMap;
    int size = 0;
    private PricingStrategy pricingStrategy;

    ParkingManager(){
        this.parkingLotList = new ArrayList<>();
        this.pricingStrategy = new VehicleBasedPricingStrategy();
        this.parkingTicketMap = new HashMap<>();
    }

    public ParkingLot getParkingLot(){
        if(size > 0){
            return parkingLotList.get(size-1);
        }
        return null;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }


    public ParkingLot createParkingLot(String parkingId ,int floorCount ,int spotCount, ParkingStrategy parkingStrategy){
        this.parkingLotList.add(new ParkingLot(parkingId, new ArrayList<>(), parkingStrategy));
        for(int i = 0; i < floorCount; i++){
            Floor f = new Floor(i, new ArrayList<>());
            this.parkingLotList.get(size).addFloor(f);
            for(int j = 0; j < spotCount; j++){
                if( j == 0){
                    f.addParkingSpot(new ParkingSpot(j, "LARGE"));
                }else if(j<3){
                    f.addParkingSpot(new ParkingSpot(j, "SMALL"));
                }else{
                    f.addParkingSpot(new ParkingSpot(j, "MEDIUM"));
                }

            }
        }
        size++;
        System.out.println("Parking Lot created with "+ floorCount + " floors and "+spotCount+ " spots per floor");
        return this.parkingLotList.get(size-1);
    }

    public ParkingTicket park(String type, String regNum, String color){
        Vehicle vehicle = new Vehicle(regNum, color, type);
        System.out.println("\n\n");
        ParkingLot.Pair pair = this.parkingLotList.get(size-1).getAvailableParkingSpot(vehicle);

        if(pair!=null){
            ParkingSpot ps = pair.parkingSpot.fillParkingSpot(vehicle);
            int floor_id = pair.floor_num;
            ParkingTicket pt = new ParkingTicket(this.parkingLotList.get(size-1).getParkingId(), floor_id, ps);
            parkingTicketMap.put(pt.getTicketNumber(), pt);
            System.out.println("ticket number: "+ pt.getTicketNumber());
            return pt;
        }

        return null;

    }

    public void unPark(String ticketNumber){
        System.out.println("\n\n");
        ParkingTicket parkingTicket = parkingTicketMap.getOrDefault(ticketNumber, null);
        if(parkingTicket != null){

            String regNumber = parkingTicket.getParkingSpot().getVehicle().getRegistrationNumber();

            long durationMillis = System.currentTimeMillis() - parkingTicket.getEntryTime();
            long duration_hours = durationMillis / (1000 * 60 * 60);
            if (duration_hours == 0) duration_hours = 1;

            double fee = this.pricingStrategy.calculateFee(parkingTicket, duration_hours);

            parkingTicket.returnTicket();
            parkingTicketMap.remove(ticketNumber);
            System.out.println("Vehicle un-parked: "+ regNumber);
            System.out.println("Parking Duration: " + duration_hours + " hour(s), Total Fee: $" + fee);
        }
        else{
            System.out.println("Invalid parking ticket");
        }

    }

    public void getFreeParkingSpotCount(String vehicle_type){

        this.getParkingLot().getFreeCount(VehicleType.valueOf(vehicle_type));
    }

    public void getParkingSpots(String vehicle_type){
        this.getParkingLot().getParkingSpots(VehicleType.valueOf(vehicle_type));
    }

    public void getOccupiedSpots(String vehicle_type){
        this.getParkingLot().getOccupiedSpots(VehicleType.valueOf(vehicle_type));
    }

}
