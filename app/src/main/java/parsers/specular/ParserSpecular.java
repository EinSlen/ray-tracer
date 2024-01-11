package parsers.specular;

import dev.appli.CustomLogger;
import parsers.IParser;
import scene.Scene;
import utilities.Color;

public class ParserSpecular implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserSpecular.class);

    Double []tabDouble = new Double[3];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=4)
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
        scene.setSpecular(new Color(tabDouble[0], tabDouble[1], tabDouble[2]));
        return true;
    }
}
