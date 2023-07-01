package WorkingWithAbstraction_01.Lab.P03StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String[] input = scanner.nextLine().split(" ");
        while (!input.equals("Exit")) {
            studentSystem.executeCommand(input);
            input = scanner.nextLine().split(" ");
        }
    }
}
