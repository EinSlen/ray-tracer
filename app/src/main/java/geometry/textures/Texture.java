package geometry.textures;

import utilities.Color;

public interface Texture {


    /**
     * Method to calculate the color of the checkerboard box
     * @param x double
     * @param y double
     * @param z double
     * @return Color
     */
    Color getColorAtPoint(double x, double y, double z);
}
