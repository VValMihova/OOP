package WorkingWithAbstraction_01.Exsersice.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        sumValue(rows, cols, matrix, value);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            moveEvil(matrix, evilRow, evilCol);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];

            sum = moveHero(matrix, sum, heroRow, heroCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static void sumValue(int rows, int cols, int[][] matrix, int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    private static long moveHero(int[][] matrix, long sum, int heroRow, int heroCol) {
        while (heroRow >= 0 && heroCol < matrix[1].length) {
            if (isInBounds(matrix, heroRow, heroCol)) {
                sum += matrix[heroRow][heroCol];
            }

            heroCol++;
            heroRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isInBounds(matrix, evilRow, evilCol)) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
