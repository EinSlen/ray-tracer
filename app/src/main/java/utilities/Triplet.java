package utilities;
public class Triplet {

    private final double x;
    private final double y;
    private final double z;

    /**
     * Constructor for a triplet
     * @param x double
     * @param y double
     * @param z double
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Method to retrieve the value of x
     * @return double
     */
    public double getX() {
        return x;
    }


    /**
     * Method to retrieve the value of y
     * @return double
     */
    public double getY() {
        return y;
    }


    /**
     * Method to retrieve the value of z
     * @return double
     */
    public double getZ() {
        return z;
    }

    /**
     * Adds the current triplet to another triplet.
     * @param triplet The triplet to add.
     * @return The resulting triplet after addition.
     */
    public Triplet add(Triplet triplet) {
        return new Triplet(x + triplet.getX(), y + triplet.getY(), z + triplet.getZ());
    }

    /**
     * Subtracts another triplet from the current triplet.
     * @param triplet The triplet to subtract.
     * @return The resulting triplet after subtraction.
     */
    public Triplet subtract(Triplet triplet) {
        return new Triplet(x - triplet.getX(), y - triplet.getY(), z - triplet.getZ());
    }

    /**
     * Multiplies the triplet by a scalar value.
     * @param scalar The scalar value.
     * @return The resulting triplet after multiplication.
     */
    public Triplet multiply(double scalar) {
        return new Triplet(x * scalar, y * scalar, z * scalar);
    }

    /**
     * Computes the scalar product of the current triplet and another triplet.
     * @param triplet The other triplet.
     * @return The scalar product result.
     */
    public double scalarProduct(Triplet triplet) {
        return x * triplet.getX() + y * triplet.getY() + z * triplet.getZ();
    }



    /**
     * Computes the vector product of the current triplet and another triplet.
     * @param triplet The other triplet.
     * @return The vector product result.
     */
    public Triplet vectorProduct(Triplet triplet) {
        return new Triplet(
                y * triplet.getZ() - z * triplet.getY(),
                z * triplet.getX() - x * triplet.getZ(),
                x * triplet.getY() - y * triplet.getX()
        );
    }

    /**
     * Computes the Schur (element-wise) product of the current triplet and another triplet.
     * @param triplet The other triplet.
     * @return The Schur product result.
     */
    public Triplet schurProduct(Triplet triplet) {
        return new Triplet(x * triplet.getX(), y * triplet.getY(), z * triplet.getZ());
    }

    /**
     * Computes the length (magnitude) of the triplet.
     * @return The length of the triplet.
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Normalizes the triplet.
     * @return The normalized triplet.
     */
    public Triplet norm() {
        double length = length();
        if(length != 0.0)
            return multiply(1.0/length);
        return this;
    }

    public String toString() {
        return "x : " + x + ", y : " + y + ", z : " + z;
    }


}