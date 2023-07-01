package WorkingWithAbstraction_01.Exsersice.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] colors = scan.nextLine().split("\\s+");
        int nToChange = Integer.parseInt(scan.nextLine());

        List<Light> trafficLights = new ArrayList<>();
        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));
            trafficLights.add(light);
        }
        for (int i = 0; i <nToChange ; i++) {
            trafficLights.forEach(light -> { light.changeColour();
            System.out.print(light.getColor()+ " ");
            });
            System.out.println();
        }
    }
}
