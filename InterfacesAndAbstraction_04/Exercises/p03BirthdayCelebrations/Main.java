package InterfacesAndAbstraction_04.Exercises.p03BirthdayCelebrations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, String> nameAndBirthDate = new HashMap<>();

        while (!input.equals("End")){

            String[] inputSplit = input.split("\\s+");
            String identifyType = inputSplit[0];


            switch (identifyType){
                case "Citizen":
                    String cityzenName = inputSplit[1];
                    int citizenAge = Integer.parseInt(inputSplit[2]);
                    String cityzenId = inputSplit[3];
                    String cityzenBirthdate = inputSplit[4];
                    Citizen citizen = new Citizen(cityzenName, citizenAge,cityzenId ,cityzenBirthdate);
                    nameAndBirthDate.put(cityzenName, cityzenBirthdate);
                    break;

                case "Robot":
                    String robotId = inputSplit[1];
                    String robotModel = inputSplit[1];
                    Robot robot = new Robot(robotId, robotModel);
                    break;
                case "Pet":
                    String petName = inputSplit[1];
                    String petBirthdate = inputSplit[2];
                    Pet pet = new Pet(petName, petBirthdate);
                    nameAndBirthDate.put(petName, petBirthdate);
                    break;
            }
            input = scan.nextLine();
        }
        String specificYearFilter = scan.nextLine();
        nameAndBirthDate.values().stream().filter(date -> date.endsWith(specificYearFilter)).forEach(System.out::println);
    }
}
