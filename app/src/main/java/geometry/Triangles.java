package geometry;
import dev.appli.CustomLogger;
import utilities.Color;
import utilities.Point;
import utilities.Triplet;
import utilities.Vector;

public class Triangles extends AObject {

    /**
     * Attribute that represents the point a of the triangle
     */
    private final Point a;

    /**
     * Attribute that represents the point b of the triangle
     */
    private final Point b;

    /**
     * Attribute that represents the point c of the triangle
     */
    private final Point c;

    /**
     * Attribute that represents the color of the triangle
     */
    private Color color;

    /**
     * Constructor of the class Triangle
     * @param a Point
     * @param b Point
     * @param c Point
     */
    public Triangles(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        CustomLogger customLogger = new CustomLogger(Triangles.class);
        customLogger.info(this.toString());
    }

    /**
     * Method to retrieve the value of the point a
     * @return Point
     */
    public Point getA() {
        return a;
    }

    /**
     * Method to retrieve the value of the point b
     * @return Point
     */
    public Point getB() {
        return b;
    }

    /**
     * Method to retrieve the value of the point c
     * @return Point
     */
    public Point getC() {
        return c;
    }

    /**
     * Method to retrieve the value of the color
     * @return Color
     */
    public Color getColor() {
        return color;
    }


    /**
     * Method to retrieve the value of the distance from the intersection
     * @param lookFrom Triplet
     * @param d Vector
     * @return double
     */
    @Override
    public double getIntersectionDistance(Triplet lookFrom, Vector d) {
        // The vertices of the triangle
        Triplet vertex0 = a.getTriplet();
        Triplet vertex1 = b.getTriplet();
        Triplet vertex2 = c.getTriplet();
        // Calculation of the edges of the triangle
        Vector edge1 = new Vector(vertex1.subtract(vertex0));
        Vector edge2 = new Vector(vertex2.subtract(vertex0));

        // Calculation of the vector product of the edges
        Vector h = d.vectorProduct(edge2.getTriplet());
        double aParam = edge1.scalarProduct(h.getTriplet());

        if (aParam > -1e-9 && aParam < 1e-9) {
            return -1; // Radius parallel to triangle
        }

        double f = 1.0 / aParam;
        Vector s = new Vector(lookFrom.subtract(vertex0));
        double u = f * s.scalarProduct(h.getTriplet());

        if (u < 0.0 || u > 1.0) {
            return -1;
        }

        Vector q = s.vectorProduct(edge1.getTriplet());
        double v = f * d.scalarProduct(q.getTriplet());

        if (v < 0.0 || u + v > 1.0) {
            return -1;
        }

        // Calculation of the intersection distance
        double t = f * edge2.scalarProduct(q.getTriplet());
        if (t > 1e-9) {
            return t; // Intersection
        }
        return -1; // No intersection
    }

    /**
     * Method to retrieve the value of the normal
     * @param p Triplet
     * @return Vector
     */
    @Override
    public Vector getNormal(Triplet p) {
        Triplet vertex0 = getA().getTriplet();
        Triplet vertex1 = getB().getTriplet();
        Triplet vertex2 = getC().getTriplet();
        Vector edge1 = new Vector(vertex1.subtract(vertex0));
        Vector edge2 = new Vector(vertex2.subtract(vertex0));
        return edge1.vectorProduct(edge2.getTriplet()).norm();
    }


    /**
     * Method to modify the value of the color
     * @param color Color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Triangles{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", color=" + color +
                '}';
    }
}