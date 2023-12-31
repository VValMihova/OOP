package Encapsulation_02.Exsersice.p04PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }


    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * toppingModifier();
    }
    private double toppingModifier(){
        double toppingMod = 0;
        switch (this.toppingType){
            case "Meat":
                toppingMod = 1.2;
                break;
            case "Veggies":
                toppingMod = 0.8;
                break;
            case "Cheese":
                toppingMod = 1.1;
                break;
            case "Sauce":
                toppingMod = 0.9;
                break;
        }
        return toppingMod;
    }
}
