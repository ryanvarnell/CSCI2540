package activity4;

import java.util.Scanner;

public class ThreeDimPointTest {
    public static void main(String[] args) {

        System.out.println("Enter two points, one per line, in the format of x y z separated by space.");
        ThreeDimPoint point1 = newPoint();
        ThreeDimPoint point2 = newPoint();

        System.out.println(point1);
    }

    public static ThreeDimPoint newPoint() {
        Scanner kbd = new Scanner(System.in);
        int x = 9, y= 9, z = 9;
        String point = kbd.nextLine();
        kbd.close();
        return new ThreeDimPoint(x, y, z);
    }
}
