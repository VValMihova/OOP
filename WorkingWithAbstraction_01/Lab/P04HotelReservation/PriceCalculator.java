package WorkingWithAbstraction_01.Lab.P04HotelReservation;

public class PriceCalculator {
    public static double calculateFinalPrice(double pricePerDay, int numberOfDays, Season currentSeason, DiscountType currentDiscount) {
        double price = pricePerDay * numberOfDays;
        price = price * currentSeason.getMultiplier();
        price = price * (100 -currentDiscount.getDiscount()) / 100;
        return price;
    }
}
