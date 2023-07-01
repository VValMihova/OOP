package Encapsulation_02.Exsersice.P02AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return;
        }
    }
}
