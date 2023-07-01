package Advanced.automotiveRepairShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }

    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(vehicle->vehicle.getVIN().equals(vin));
    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return Collections.min(vehicles,(f, s)->Integer.compare(f.getMileage(),s.getMileage()));
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        for (Vehicle vehicle : vehicles) {
            sb.append(System.lineSeparator());
            sb.append(vehicle);
        }
        return sb.toString().trim();
    }

}
