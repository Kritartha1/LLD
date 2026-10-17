package com.company.parkinglot;

import java.util.*;

public interface ParkingStrategy {

    ParkingLot.Pair findParkingSpot(Vehicle vehicle, List<Floor> floors);
}
