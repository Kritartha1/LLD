package com.company.parkinglot;

public interface PricingStrategy {
    double calculateFee(ParkingTicket ticket, long durationHours);

}
