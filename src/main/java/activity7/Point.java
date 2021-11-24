// Class for a point on a cartesian plane
// @author Ryan Varnell

package activity7;

public class Point {
    private double x;
    private double y;

    // Default constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Two point constructor
    // @param   x   User-provided x value
    // @param   y   User-provided y value
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter for X
    // @return  X value
    public double getX() {
        return x;
    }

    // Getter for Y
    // @return  Y value
    public double getY() {
        return y;
    }

    // Formats a string for the point
    // @return  the point in a "(x,y)" formatted string
    public String toString() {
        return ("(" + x + ", " + y + ")");
    }

    // Calculates the distance between two points
    // @param   point2  The second point to be included in the distance equation
    // @return          the distance between this point and another
    public double distance(Point point2) {
        return Math.sqrt(Math.pow(point2.x - this.x, 2) + Math.pow(point2.y - this.y,2));
    }
}
