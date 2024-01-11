package scene;
import dev.appli.CustomLogger;
import utilities.Triplet;

public class Camera {
    CustomLogger customLogger = new CustomLogger(Camera.class);

    /**
     * Attribute that represents eye position
     */
    private final Triplet lookFrom;

    /**
     * Attribut that represents the target point of the eye
     */
    private final Triplet lookAt;

    /**
     * Attribut that represents the upward direction of the eye
     */
    private final Triplet up;

    /**
     * Attributs that represents the field of view in degrees
     */
    private int field;

    /**
     * Constructor of the class Camera
     * @param lookFrom Triplet
     * @param lookAt Triplet
     * @param up Triplet
     * @param field int
     */
    public Camera(Triplet lookFrom, Triplet lookAt, Triplet up, int field) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.field = field;
        customLogger.info(this.toString());
    }


    /**
     * Method to retrieve the value of the field of view
     * @return int
     */
    public int getField() {
        return field;
    }

    /**
     * Method to modify the value of the field of view
     * @param field int
     */

    public void setField(int field) {
        this.field = field;
    }


    /**
     * Method to retrieve the value of the eye position
     * @return Triple
     */
    public Triplet getLookFrom() {
        return lookFrom;
    }

    /**
     * Method to retrieve the value of the target point of the eye
     * @return Triplet
     */
    public Triplet getLookAt() {
        return lookAt;
    }


    /**
     * Method to retrieve the value of the field of view
     * @return Triple
     */
    public Triplet getUp() {
        return up;
    }

    /**
     * Method to display values of the class Camera
     * @return String
     */
    @Override
    public String toString() {
        return "Camera : " + "lookFrom =" + lookFrom +", lookAt = " + lookAt +
                ", up = " + up +
                ", field = " + field +
                '}';
    }
}

