package utilities;

public class Color {
    private final Triplet triplet;


    /**
     * Constructor that generates a color that is a triplet
     * @param triplet Triplet
     */
    public Color(Triplet triplet){
        this.triplet = triplet;
    }


    /**
     * Constructor that generates a color that is a triplet
     * @param r double
     * @param g double
     * @param b double
     */
    public Color(double r, double g, double b){
        triplet = new Triplet(r,g,b);
    }

    public Triplet getTriplet() {
        return triplet;
    }

    public double getR() {
        return triplet.getX();
    }

    public double getG() {
        return triplet.getY();
    }

    public double getB() {
        return triplet.getZ();
    }

    /**
     * Methods to make an addition with two colors (triplets)
     * @param triplet Triplet
     * @return Color
     */
    public Color add(Triplet triplet){
        return new Color(this.triplet.add(triplet));
    }


    /**
     * Methods to make a multiplication of a triplet by a scalar
     * @param scalar double
     * @return Color
     */
    public Color multiply(double scalar){
        return  new Color(this.triplet.multiply(scalar));
    }


    /**
     * Methods to make a Schur product
     * @param triplet Triplet
     * @return Color
     */
    public Color schurProduct(Triplet triplet){
        return new Color(this.triplet.schurProduct(triplet));
    }


    /**
     * Methods to display the values of the triplet
     * @return String
     */
    @Override
    public String toString() {
        return "Color : " + "r = " + triplet.getX() +  "g = " + triplet.getY() +"b = " + triplet.getZ() ;
    }

}
