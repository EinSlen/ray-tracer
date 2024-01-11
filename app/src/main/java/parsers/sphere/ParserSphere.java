package parsers.sphere;

import dev.appli.CustomLogger;
import geometry.Sphere;
import parsers.IParser;
import scene.Scene;
import utilities.Triplet;

public class ParserSphere implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserSphere.class);

    Double[] tabDouble = new Double[4];

    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if (tab.length != 5)
            return false;
        for (int i = 1; i < tab.length; i++) {
            double tmp;
            try {
                tmp = Double.parseDouble(tab[i]);
            } catch (NumberFormatException e) {
                customLogger.error(e.getMessage());
                return false;
            }
            tabDouble[i - 1] = tmp;
        }
        Sphere sphere = new Sphere(new Triplet(tabDouble[0], tabDouble[1], tabDouble[2]), tabDouble[3]);
        sphere.setColor(scene.getDiffuse());
        scene.addObjects(sphere);

        return true;
    }
}

