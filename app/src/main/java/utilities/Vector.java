package utilities;


public class Vector {


    /**
     * Attribut that represents the vector (a triplet)
     */
    private final Triplet triplet;


    /**
     * Constructor for a vector
     * @param x double
     * @param y double
     * @param z double
     */
    public Vector(double x, double y, double z) {
        triplet = new Triplet(x, y, z);
    }

    /**
     * Constructor for a vector
     * @param triplet Triplet
     */
    public Vector(Triplet triplet) {
        this.triplet = triplet;
    }

    /**
     * Getter triplet
     * @return Triplet
     */
    public Triplet getTriplet() {
        return triplet;
    }

    /**
     * Adds another triplet to the current vector.
     * @param triplet The triplet to add.
     * @return The resulting vector after addition.
     */
    public Vector add(Triplet triplet) {
        return new Vector(this.triplet.add(triplet));
    }

    /**
     * Subtracts another triplet from the current vector.
     * @param triplet The triplet to subtract.
     * @return The resulting vector after subtraction.
     */
    public Vector subtract(Triplet triplet) {
        return new Vector(this.triplet.subtract(triplet));
    }

    /**
     * Multiplies the vector by a scalar value.
     * @param scalar The scalar value.
     * @return The resulting vector after multiplication.
     */
    public Vector multiply(double scalar) {
        return new Vector(this.triplet.multiply(scalar));
    }

    /**
     * Computes the scalar product of the current vector and another triplet.
     * @param triplet The other triplet.
     * @return The scalar product result.
     */
    public double scalarProduct(Triplet triplet) {
        return this.triplet.scalarProduct(triplet);
    }

    /**
     * Computes the vector product of the current vector and another triplet.
     * @param triplet The other triplet.
     * @return The vector product result.
     */
    public Vector vectorProduct(Triplet triplet) {
        return new Vector(this.triplet.vectorProduct(triplet));
    }

    /**
     * Computes the length of the vector.
     * @return The length of the vector.
     */
    public double length() {
        return this.triplet.length();
    }

    /**
     * Normalizes the vector.
     * @return The normalized vector.
     */
    public Vector norm() {
        return new Vector(this.triplet.norm());
    }

    /**
     * Method to display the vector
     * @return String
     */
    public String toString() {
        return this.triplet.toString();
    }

}
