package Inheritance_03.Exercises.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("Beast!")) {
            String animalType = input;
            String[] animalData = scan.nextLine().split("\\s+");

            switch (animalType) {
                case "Cat":
                    Cat cat = new Cat(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                    System.out.println(cat);
                    break;
                case "Dog":
                    Dog dog = new Dog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                    System.out.println(dog);
                    break;
                case "Frog":
                    Frog frog = new Frog(animalData[0], Integer.parseInt(animalData[1]), animalData[2]);
                    System.out.println(frog);
                    break;
                case "Kitten":
                    Kitten kitten = new Kitten(animalData[0], Integer.parseInt(animalData[1]));
                    System.out.println(kitten);
                    break;
                case "Tomcat":
                    Tomcat tomcat = new Tomcat(animalData[0], Integer.parseInt(animalData[1]));
                    System.out.println(tomcat);
                    break;
            }

            input = scan.nextLine();
        }
    }
}
