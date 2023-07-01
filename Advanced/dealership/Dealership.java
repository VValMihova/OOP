package Advanced.dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.isEmpty()) {
            return null;
        }
        return Collections.max(data,(f, s)->Integer.compare(f.getYear(),s.getYear()));
        }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(car->car.getManufacturer().equals(manufacturer)
                &&car.getModel().equals(model)).findAny().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(name).append(":");
        for (Car car : data) {
            sb.append(System.lineSeparator());
            sb.append(car);
        }
        return sb.toString();
    }
}


