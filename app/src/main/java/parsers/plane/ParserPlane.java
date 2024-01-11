package parsers.plane;

import dev.appli.CustomLogger;
import geometry.Plane;
import parsers.IParser;
import parsers.maxverts.ParserMaxverts;
import scene.Scene;
import utilities.Point;
import utilities.Triplet;

import java.util.Arrays;

public class ParserPlane implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserPlane.class);


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
        Point point = new Point(new Triplet(tabDouble[0],tabDouble[1],tabDouble[2]));
        Triplet normal = new Triplet(tabDouble[3],tabDouble[4],tabDouble[5]);
        Plane plane = new Plane(point, normal);
        plane.setColor(scene.getDiffuse());
        scene.addObjects(plane);
        return true;
    }
}
