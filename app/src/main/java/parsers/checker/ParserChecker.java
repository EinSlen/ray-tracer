package parsers.checker;

import dev.appli.CustomLogger;
import geometry.textures.CheckerboardTexture;
import parsers.IParser;
import scene.Scene;
import utilities.Color;


public class ParserChecker implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserChecker.class);

    Double []tabDouble = new Double[7];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=8)
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

        Color color1 = new Color(tabDouble[0], tabDouble[1], tabDouble[2]);
        Color color2 = new Color(tabDouble[3], tabDouble[4], tabDouble[5]);
        CheckerboardTexture checker = new CheckerboardTexture(color1, color2, tabDouble[6]);
        scene.setChecker(checker);
        return true;
    }
}
