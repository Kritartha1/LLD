package com.company.parkinglot;

import java.util.*;

public class Main {



    public static void main(String[] args) {
        int c = 0;
        ParkingManager pm = new ParkingManager();


        Scanner sc = new Scanner(System.in);
        showMenu();
        System.out.println("Please enter you commands..");
        LowestFloorFirstStrategy lowestFloorFirstStrategy = new LowestFloorFirstStrategy();
        while (sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                continue;
            }

            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command){
                case "create_parking_lot":
                    pm.createParkingLot(parts[1],
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            lowestFloorFirstStrategy);
                    break;
                case "park":
                    pm.park(parts[1], parts[2], parts[3]);
                    break;
                case "unpark":
                    pm.unPark(parts[1]);
                    break;
                case "display":
                    if (parts[1].equals("free_count")) pm.getFreeParkingSpotCount(parts[2]);
                    else if (parts[1].equals("free_slots")) pm.getParkingSpots(parts[2]);
                    else if (parts[1].equals("occupied_slots")) pm.getOccupiedSpots(parts[2]);
                    break;
                case "exit":
                    return;
                case "menu":
                    showMenu();
                    break;
            }
        }

        sc.close();

    }

    static void showMenu(){
        System.out.println("==================Menu===================");
        System.out.println("1. `create_parking_lot <parking_lot_id> <num_of_floors> <slots_per_floor>`   : This creates a parking lot");
        System.out.println("2. `park <type> <reg_num> <color_of_vehicle>`   : Parks the vehicle");
        System.out.println("3. `unpark <parking_ticket_number> `   : This unparks the vehicle");
        System.out.println("4. `display <free_count> | <free_slot> | <occupied_slots>`   : This displays info about parking lot");
        System.out.println("5. `menu` : show menu");
        System.out.println();

        System.out.println("Enter your choice: ");
    }

}
