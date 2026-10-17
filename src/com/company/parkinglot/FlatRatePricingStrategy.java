package com.company.parkinglot;

public class FlatRatePricingStrategy implements PricingStrategy {
    private double hourlyRate = 20.0; // Flat $20/hour

    @Override
    public double calculateFee(ParkingTicket ticket, long durationHours) {
        // At least 1 hour minimum charge
        long chargeableHours = Math.max(1, durationHours);
        return chargeableHours * hourlyRate;
    }
}