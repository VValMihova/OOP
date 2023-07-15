package Polymorphism_05.Exsersice.p01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] carData = scan.nextLine().split("\\s+");
        String[] truckData = scan.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] command = scan.nextLine().split("\\s+");
            String commandName = command[0];
            String vehicleType = command[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(command[2]);
                    String driveMessage = vehicleMap.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
                    break;

                case "Refuel":
                    double liters = Double.parseDouble(command[2]);
                    if (vehicleType.equals("Car")) {
                        car.refuel(liters);

                    } else if (vehicleType.equals("Truck")) {
                        truck.refuel(liters);
                    }
                    break;
            }
        }

        for (Map.Entry<String, Vehicle> entry : vehicleMap.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue().getFuelQuantity());
        }
    }
}
