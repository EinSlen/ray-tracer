package light;
import dev.appli.CustomLogger;
import utilities.Color;
import utilities.Point;
import utilities.Triplet;
import utilities.Vector;

public class PonctualLight extends Light {
    /**
     * Attribute that represent a point
     */
    private final Point point;

    /**
     * Constructor of the class PonctualLight
     * @param color Color
     * @param position Triplet
     */
    public PonctualLight(Color color, Triplet position) {
        super(color);
        this.point = new Point(position);
        CustomLogger customLogger = new CustomLogger(PonctualLight.class);
        customLogger.info(this.toString());
    }


    /**
     * Method to retrieve the position of the point
     * @return Triplet
     */
    public Triplet getPosition() {
        return point.getTriplet();
    }


    /**
     * Method to retrieve the value of the point
     * @return Point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Method to retrieve the value of the vector
     * @return Vector
     */
    @Override
    public Vector getVector() {
        return new Vector(point.getTriplet());
    }


    @Override
    public String toString() {
        return "PonctualLight{" +
                "point=" + point +
                '}';
    }
}

