package parsers.vertex;

import dev.appli.CustomLogger;
import parsers.IParser;
import scene.Scene;
import utilities.Point;

public class ParserVertex implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserVertex.class);

    Double []tabDouble = new Double[3];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=4)
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
        if(scene.getPoints().size()<scene.getNbPoints()){
            scene.getPoints().add(new Point(tabDouble[0], tabDouble[1], tabDouble[2]));
            return true;
        }
        return false;
    }
}
