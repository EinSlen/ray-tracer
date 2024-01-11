package parsers.point;

import dev.appli.CustomLogger;
import geometry.Plane;
import light.Light;
import light.PonctualLight;
import parsers.IParser;
import parsers.plane.ParserPlane;
import scene.Scene;
import utilities.Color;
import utilities.Point;
import utilities.Triplet;
import java.util.Arrays;

public class ParserPoint implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserPoint.class);

    Double []tabDouble = new Double[6];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=7)
            return false;
        for (int i = 1; i < tab.length; i++) {
            double tmp;
            try {
                tmp = Double.parseDouble(tab[i]);
            } catch (NumberFormatException e){
                customLogger.error(e.getMessage());
                return false;
            }
            tabDouble[i-1] = tmp;
        }

        Point point = new Point(tabDouble[0],tabDouble[1],tabDouble[2]);
        Color color = new Color(new Triplet(tabDouble[3],tabDouble[4],tabDouble[5]));
        PonctualLight ponctualLight = new PonctualLight(color, point.getTriplet());
        scene.addPonctualLights(ponctualLight);
        return true;
    }
}
