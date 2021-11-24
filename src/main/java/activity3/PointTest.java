// Class for testing the Point class
// @author Ryan Varnell

package activity3;

public class PointTest {
    public static void main(String[] args) {
        Point point1, point2, point3;
        point1 = new Point();
        point2 = new Point(2, 5);
        point3 = new Point(12, 9);

        // Printing out the points.
        System.out.println("Point 1 is: " + point1 +
                "\nPoint 2 is: " + point2 +
                "\nPoint 3 is: " + point3);

        // Printing the distance between said points.
        System.out.println("The distance between point 1 and 2 is: " + point1.distance(point2) +
                "\nThe distance between point 1 and 3 is: " + point1.distance(point3) +
                "\nThe distance between point 2 and 3 is: " + point2.distance(point3));
    }
}
