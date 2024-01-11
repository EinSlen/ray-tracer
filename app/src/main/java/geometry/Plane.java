package geometry;

import dev.appli.CustomLogger;
import utilities.Color;
import utilities.Point;
import utilities.Triplet;
import utilities.Vector;


public class Plane extends AObject {


    /**
     * Attribute that represents the coordinate of the plane
     */
    private final Point coordinate;

    /**
     * Attribute that represents the normal of the plane
     */
    private final Triplet normal;

    /**
     * Attribute that represents the color of the plane
     */
    private Color color;


    /**
     * Constructor of the class Plane
     * @param coordinate Point
     * @param normal Triplet
     */
    public Plane(Point coordinate, Triplet normal) {
        this.coordinate = coordinate;
        this.normal = normal;
        this.color = new Color(0, 0, 0);
        CustomLogger customLogger = new CustomLogger(Plane.class);
        customLogger.info(this.toString());
    }


    /**
     * Method to retrieve the color value
     * @return Color
     */
    @Override
    public Color getColor() {
        return color;
    }


    /**
     * Method to modify the color value
     * @param color Color
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }



    /**
     * Method to retrieve the normal value
     * @param p Triplet
     * @return Vector
     */
    public Vector getNormal(Triplet p) {
        return new Vector(normal);
    }


    /**
     * Method to retrieve the value of the distance from the intersection
     * @param lookFrom Triplet
     * @param d Vector
     * @return double
     */

    @Override
    public double getIntersectionDistance(Triplet lookFrom, Vector d) {
        double denominator = d.scalarProduct(normal); // d · n
        if (denominator == 0) {
            return -1.0; // Radius parallel to the plane
        }
        Vector pq = new Vector(coordinate.subtract(lookFrom).getTriplet()); // q - lookFrom
        double t = pq.scalarProduct(normal) / denominator;
        if (t < 0) {
            return -1.0; // The intersection point is behind the viewpoint
        }
        return t;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "coordinate=" + coordinate +
                ", normal=" + normal +
                ", color=" + color +
                '}';
    }
}