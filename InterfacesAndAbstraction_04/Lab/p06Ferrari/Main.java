package InterfacesAndAbstraction_04.Lab.p06Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String driverName = scan.nextLine();
        Car ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
