package InterfacesAndAbstraction_04.Exercises.p04FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, Buyer> buyersMap = new HashMap<>();

        while (n-- > 0) {
            String[] inputData = scan.nextLine().split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            if (inputData.length == 3) {
                String group = inputData[2];
                Rebel rebel = new Rebel(name, age, group);
                buyersMap.put(name, rebel);

            } else if (inputData.length == 4) {
                String id = inputData[2];
                String birthDate = inputData[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyersMap.put(name, citizen);

            }
        }
        String buyer = scan.nextLine();

        while (!buyer.equals("End")) {

            if (buyersMap.containsKey(buyer)) {
                buyersMap.get(buyer).buyFood();
            }

            buyer = scan.nextLine();
        }
        int foodSum = buyersMap.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(foodSum);
    }
}
