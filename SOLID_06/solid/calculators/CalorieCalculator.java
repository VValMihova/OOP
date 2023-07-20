package SOLID_06.solid.calculators;

import SOLID_06.solid.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {


    public CalorieCalculator() {
    }

    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }

        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }

}
