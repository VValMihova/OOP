package WorkingWithAbstraction_01.Lab.P02PointinRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] rectanglePointsCoordinates =
                Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = new Point(rectanglePointsCoordinates[0], rectanglePointsCoordinates[1]);
        Point topRight = new Point(rectanglePointsCoordinates[2], rectanglePointsCoordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int inputCount = Integer.parseInt(scan.nextLine());

        while (inputCount-- > 0){
            int[] pointCoordinates =
                    Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(pointCoordinates[0], pointCoordinates[1]);
            System.out.println(rectangle.contains(point));
        }


    }
}
