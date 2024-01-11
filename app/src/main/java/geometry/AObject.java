package geometry;

import utilities.Color;
import utilities.Triplet;
import utilities.Vector;

public abstract class AObject {

    /**
     * Attribut that represents a color
     */
    private Color color;

    /**
     * Method to retrieve the value of the color
     * @return Color
     */
    public abstract Color getColor();

    /**
     * Method to modify the value of the color
     * @param color Color
     */
    public abstract void setColor(Color color);

    /**
     * Method to retrieve the value of the distance from the intersection
     * @param lookFrom Triplet
     * @param d Vector
     * @return double
     */
    public abstract double getIntersectionDistance(Triplet lookFrom, Vector d);

    /**
     * Method to retrieve the value of the normal vector
     * @param p Triplet
     * @return Vector
     */
    public abstract Vector getNormal(Triplet p);

}