package Polymorphism_05.Exsersice.p01Vehicles;

public class Truck extends Vehicle {

    private static final double ADDITIONAL_AC_CONSUMPTION = 1.6;
    private static final double REFUEL_PERCENTS = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_AC_CONSUMPTION);
    }


    @Override
    public void refuel(double liters) {
        liters = liters * REFUEL_PERCENTS;
        super.refuel(liters);
    }
}
