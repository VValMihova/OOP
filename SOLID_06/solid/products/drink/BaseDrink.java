package SOLID_06.solid.products.drink;

import SOLID_06.solid.products.Product;

public abstract class BaseDrink implements Drink {
    private double milliliters;
    private double density;
    private double caloriesPer100grams;

    public BaseDrink(double milliliters, double density, double caloriesPer100grams) {
        this.milliliters = milliliters;
        this.density = density;
        this.caloriesPer100grams = caloriesPer100grams;
    }

    @Override
    public double getDensity() {
        return density;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100grams / 100) * (milliliters * density);
    }

    @Override
    public double getLiters() {
        return this.milliliters / 1000;
    }

}
