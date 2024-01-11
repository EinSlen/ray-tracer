
package geometry;
import dev.appli.CustomLogger;
import utilities.Color;
import utilities.Triplet;
import utilities.Vector;

public class Sphere extends AObject {

    /**
     * Attribute that represents the coordinate of the sphere
     */
    private final Triplet coordinate;

    /**
     * Attribute that represents the radius of the sphere
     */
    private final double radius;

    /**
     * Attribute that represents the color of the sphere
     */
    private Color color;

    /**
     * Constructor of the class sphere
     * @param coordinate Triplet
     * @param radius double
     */
    public Sphere(Triplet coordinate, double radius) {
        this.coordinate = coordinate;
        this.radius = radius;
        CustomLogger customLogger = new CustomLogger(Sphere.class);
        customLogger.info(this.toString());
    }

    /**
     * Method to retrieve the coordinate value
     * @return Triplet
     */
    public Triplet getCoordinate() {
        return coordinate;
    }

    /**
     * Method to retrieve the radius value
     * @return double
     */
    public double getRadius(){
        return radius;
    }

    /**
     * Method to retrieve the color value
     * @return Color
     */
    public Color getColor() {
        return color;
    }


    /**
     * Method to modify the color value
     * @param color Color
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * Method to retrieve the value of the distance from the intersection
     * @param lookFrom Triplet
     * @param d Vector
     * @return double
     */
    public double getIntersectionDistance(Triplet lookFrom, Vector d) {
        // Calculates the intersection distance between the radius (lookFrom, d) and this sphere
        Vector oc = new Vector(lookFrom.subtract(coordinate));
        double a = d.scalarProduct(d.getTriplet());
        double b = 2.0 * oc.scalarProduct(d.getTriplet());
        double c = oc.scalarProduct(oc.getTriplet()) - radius * radius;
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            // No intersection
            return -1.0;
        }
        // Calculates the solutions of the quadratic equation
        double t1 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
        double t2 = (-b + Math.sqrt(discriminant)) / (2.0 * a);

        // The intersection distance is the smallest positive value between t1 and t2
        if (t1 > 0 && (t1 < t2 || t2 < 0)) {
            return t1;
        } else if (t2 > 0) {
            return t2;
        } else {
            return -1.0; // No intersection
        }
    }

    /**
     * Methods to retrieve the normal vector
     * @param p Triplet
     * @return Vector
     */
    @Override
    public Vector getNormal(Triplet p) {
        Triplet cc = getCoordinate();
        Vector oc = new Vector(p.subtract(cc));
        return oc.multiply(1.0 / oc.length());
    }


    @Override
    public String toString() {
        return "Sphere{" +
                "coordinate=" + coordinate +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}