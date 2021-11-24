package activity7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readPointFile {
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputStream = loadFile("pointList.txt");
        System.out.println("There are " + points.size() + " points.");

        double xTotal = 0, yTotal = 0;
        for (Point p : points
             ) {
            xTotal += p.getX();
            yTotal += p.getY();
        }
        Point meanPoint = new Point(xTotal / points.size(), yTotal / points.size());
        System.out.println("The mean point of all points is " + meanPoint);

        for (Point p :
                points) {
            System.out.println("The distance between " + p + " and the mean point, " + meanPoint + ", is " +
                    p.distance(meanPoint));
        }
    }

    public static Scanner loadFile(String fileName) {
        Scanner inputStream = null;

        // Tries to load the given file and returns it in a Scanner if successful.
        // Throws FileNotFoundException and exits program if not.
        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("No such file.");
            System.exit(1);
        }
        return inputStream;
    }

    public static void extractPoints(Scanner inputStream) {
        while (inputStream.hasNextLine()) {
            points.add(new Point(inputStream.nextDouble(), inputStream.nextDouble()));
        }
    }
}
