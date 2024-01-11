package light;
import dev.appli.CustomLogger;
import utilities.Color;
import utilities.Vector;

public class DirectionalLight extends Light {
    private final CustomLogger customLogger = new CustomLogger(DirectionalLight.class);

    /**
     * Attribut that represent the vector of the light
     */
    private final Vector vector;

    /**
     * Constructor of the class DirectionalLight
     * @param vector Vector
     * @param color Color
     */
    public DirectionalLight(Vector vector, Color color){
        super(color);
        this.vector = vector;
        customLogger.info(this.toString());
    }

    /**
     * Method to retrieve the value of the vector
     * @return Vector
     */
    public Vector getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return "DirectionalLight{" +
                "customLogger=" + customLogger +
                ", vector=" + vector +
                '}';
    }

}
