package Inheritance_03.Exercises.p04NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{
    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(8.0);
    }
}
