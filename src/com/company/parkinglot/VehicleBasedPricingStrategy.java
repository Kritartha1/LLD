package com.company.parkinglot;


public class VehicleBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFee(ParkingTicket ticket, long durationHours) {
        long hours = Math.max(1, durationHours);
        VehicleType type = ticket.getParkingSpot().getVehicle().getType();

        switch (type) {
            case BIKE:
                return hours * 10.0; // $10/hour
            case CAR:
                return hours * 20.0; // $20/hour
            case TRUCK:
                return hours * 50.0; // $50/hour
            default:
                return hours * 15.0;
        }
    }
}