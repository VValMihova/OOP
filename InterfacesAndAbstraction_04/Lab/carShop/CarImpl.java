package InterfacesAndAbstraction_04.Lab.carShop;

public class CarImpl implements Car {
    private int TYRES = 4;

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;


    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    public String countryProduced() {
        return countryProduced;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("This is %s produced in %s and have %s tires", getModel(), countryProduced(), CarImpl.TIRES));
        return sb.toString();
    }
}
