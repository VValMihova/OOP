package Polymorphism_05.Exsersice.p01Vehicles;

public class Car extends Vehicle {
    private static final double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_AC_CONSUMPTION);
    }

}
