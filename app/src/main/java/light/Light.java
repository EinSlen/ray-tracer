package light;
import utilities.Color;
import utilities.Vector;

public abstract class Light {
    /**
     * Attribut that represent the color of the light
     */
    private final Color color;

    /**
     * Constructor of the class Light
     * @param color Color
     */
    public Light(Color color) {
        this.color = color;
    }

    /**
     * Method to retrieve the value of the color
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Method to retrieve the value of the vector
     * @return Vector
     */
    public abstract Vector getVector();


    @Override
    public String toString() {
        return "Light{" +
                "color=" + color +
                '}';
    }
}
