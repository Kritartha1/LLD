package com.company.parkinglot;

public class ParkingTicket {


    private String ticketNumber;
    private ParkingSpot parkingSpot;
    private long entryTime;

    ParkingTicket(String parkingId, int floor, ParkingSpot parkingSpot){
        this.setTicket(parkingId, floor, parkingSpot);
        this.parkingSpot = parkingSpot;
        this.entryTime = System.currentTimeMillis();
    }

    public long getEntryTime(){
        return entryTime;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    private void setTicket(String parkingId, int floor, ParkingSpot parkingSpot){
        this.ticketNumber = parkingId+"_"+floor+"_"+parkingSpot.getId();
        this.parkingSpot = parkingSpot;
        System.out.println("Ticket generated for vehicle: "+ this.parkingSpot.getVehicle().getRegistrationNumber());
    }

    public void returnTicket(){
        System.out.println("Ticket returned: "+ this.parkingSpot.getVehicle().getRegistrationNumber());
        this.parkingSpot.clearParkingSpot();
        this.parkingSpot = null;
        this.ticketNumber = null;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
