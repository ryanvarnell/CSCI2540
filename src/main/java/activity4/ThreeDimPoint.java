package activity4;

public class ThreeDimPoint extends Point{
    private double z;

    public ThreeDimPoint() {
        super();
        z = 0;
    }

    public ThreeDimPoint(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getZ() + ")";
    }

    public double distance(ThreeDimPoint point2) {
        return Math.sqrt(Math.pow(point2.getX() - this.getX(), 2) + Math.pow(point2.getY() - this.getY(),2)
                + Math.pow(point2.getZ() - this.getZ(), 2));
    }

    public ThreeDimPoint midPoint(ThreeDimPoint point2) {
        return new ThreeDimPoint((this.getX() + point2.getX()) / 2, (this.getY() + point2.getY()) / 2,
                (this.getZ() + point2.getZ()) / 2);
    }
}
