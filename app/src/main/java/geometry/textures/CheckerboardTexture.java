package geometry.textures;

import dev.appli.CustomLogger;
import utilities.Color;

public class CheckerboardTexture implements Texture {


    /**
     * Attribute that represents the first color
     */
    private final Color color1;

    /**
     * Attribute that represents the second color
     */
    private final Color color2;

    /**
     * Attribute that represents the size
     */
    private final double size;


    /**
     * Constructor of the class CheckerboardTexture
     * @param color1 Color
     * @param color2 Color
     * @param size double
     */
    public CheckerboardTexture(Color color1, Color color2, double size) {
        this.color1 = color1;
        this.color2 = color2;
        this.size = size;
        CustomLogger customLogger = new CustomLogger(CheckerboardTexture.class);
        customLogger.info(this.toString());
    }


    /**
     * Method to calculate the color of the checkerboard box
     * @param x double
     * @param y double
     * @param z double
     * @return Color
     */
    @Override
    public Color getColorAtPoint(double x, double y, double z) {
        double checkX = Math.abs(x) / size;
        double checkY = Math.abs(z) / size;
        if ((checkX - Math.floor(checkX) < 0.5) ^ (checkY - Math.floor(checkY) < 0.5)) {
            return color1;
        } else {
            return color2;
        }
    }

    @Override
    public String toString() {
        return "CheckerboardTexture{" +
                "color1=" + color1 +
                ", color2=" + color2 +
                ", size=" + size +
                '}';
    }
}
