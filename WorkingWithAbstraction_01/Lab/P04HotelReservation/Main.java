package WorkingWithAbstraction_01.Lab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] reservationInfo = scan.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(reservationInfo[0]);
        int numberOfDays = Integer.parseInt(reservationInfo[1]);
        Season currentSeason = Season.valueOf(reservationInfo[2]);
        DiscountType currentDiscount = DiscountType.valueOf(reservationInfo[3]);
        double finalPrice = PriceCalculator.calculateFinalPrice(pricePerDay, numberOfDays, currentSeason, currentDiscount);
        System.out.printf("%.2f", finalPrice);

    }
}
