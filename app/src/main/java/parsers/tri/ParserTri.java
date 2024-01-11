package parsers.tri;

import dev.appli.CustomLogger;
import geometry.Triangles;
import parsers.IParser;
import scene.Scene;

import java.util.Arrays;

public class ParserTri implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserTri.class);

    int []tabInt = new int[3];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=4)
            return false;
        for (int i = 1; i < tab.length; i++) {
            int tmp;
            try {
                tmp = Integer.parseInt(tab[i]);
            } catch (NumberFormatException e){
                customLogger.error(e.getMessage());
                return false;
            }
            tabInt[i-1] = tmp;
        }
        Triangles triangles = new Triangles(scene.getPoints().get(tabInt[0]),scene.getPoints().get(tabInt[1]),scene.getPoints().get(tabInt[2]));
        triangles.setColor(scene.getDiffuse());
        scene.addObjects(triangles);
        return true;
    }
}
