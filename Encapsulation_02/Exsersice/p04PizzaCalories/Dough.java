package Encapsulation_02.Exsersice.p04PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            invalidDoughEx();
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") ||
                bakingTechnique.equals("Chewy") ||
                bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            invalidDoughEx();
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {

        return (2 * this.weight) * flourModifier() * bakingModifier();
    }

    private void invalidDoughEx() {
        throw new IllegalArgumentException("Invalid type of dough.");
    }

    private double flourModifier() {
        double flourMod = 0.0;
        switch (this.flourType) {
            case "White":
                flourMod = 1.5;
                break;
            case "Wholegrain":
                flourMod = 1.0;
                break;
        }
        return flourMod;
    }

    private double bakingModifier() {
        double bakingMod = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                bakingMod = 0.9;
                break;
            case "Chewy":
                bakingMod = 1.1;
                break;
            case "Homemade":
                bakingMod = 1.0;
                break;
        }
        return bakingMod;
    }
}
