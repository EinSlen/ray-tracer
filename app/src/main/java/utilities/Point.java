package utilities;

public class Point {
    private final Triplet triplet;

    /**
     * Constructor for a Point
     * @param triplet Triplet
     */
    public Point(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Constructor for a Point
     * @param x double
     * @param y double
     * @param z double
     */
    public Point(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Method to retrieve the value of the triplet
     * @return Triplet
     */
    public Triplet getTriplet() {
        return triplet;
    }

    /**
     * Subtract a Triplet from the current Point.
     * @param triplet The Triplet to subtract.
     * @return The resulting Point after subtraction.
     */
    public Point subtract(Triplet triplet) {
        return new Point(this.triplet.subtract(triplet));
    }

    /**
     * Multiply the Point's coordinates by a scalar value.
     * @param scalar The scalar value.
     * @return The resulting Point after multiplication.
     */
    public Point multiply(double scalar) {
        return new Point(this.triplet.multiply(scalar));
    }

    @Override
    public String toString() {
        return "Point{" +
                "triplet=" + triplet +
                '}';
    }
}