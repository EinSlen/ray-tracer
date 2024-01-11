package parsers.camera;

import dev.appli.CustomLogger;
import parsers.IParser;
import parsers.ambient.ParserAmbient;
import scene.Camera;
import scene.Scene;
import utilities.Triplet;

import java.util.Arrays;

public class ParserCamera implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserCamera.class);

    Double []tabDouble = new Double[10];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=11)
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
        Triplet lookFrom = new Triplet(tabDouble[0], tabDouble[1], tabDouble[2]);
        Triplet lookAt = new Triplet(tabDouble[3], tabDouble[4], tabDouble[5]);
        Triplet up = new Triplet(tabDouble[6], tabDouble[7], tabDouble[8]);
        scene.addCamera(new Camera(lookFrom,lookAt,up, tabDouble[9].intValue()));
        return true;
    }
}
