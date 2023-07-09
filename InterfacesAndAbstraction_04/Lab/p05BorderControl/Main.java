package InterfacesAndAbstraction_04.Lab.p05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> ids = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")){
            String[] inputParts = input.split("\\s+");

            if (inputParts.length == 2){
                Identifiable robot = new Robot(inputParts[0],inputParts[1] );
                ids.add(inputParts[1]);
            } else if (inputParts.length==3) {
                Identifiable citizen = new Citizen(inputParts[0], Integer.parseInt(inputParts[1]), inputParts[2]);
                ids.add(inputParts[2]);
            }
            input = scan.nextLine();
        }
        String fakeIdIdentificator = scan.nextLine();
        ids.stream().filter(id-> id.endsWith(fakeIdIdentificator)).forEach(System.out::println);

    }
}
