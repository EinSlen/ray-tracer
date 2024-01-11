package parsers.diffuse;

import dev.appli.CustomLogger;
import parsers.IParser;
import parsers.checker.ParserChecker;
import scene.Scene;

import java.util.Arrays;

public class ParserDiffuse implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserDiffuse.class);

    Double []tabDouble = new Double[3];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=4)
            return false;
        for (int i = 1; i < tab.length; i++) {
            double tmp;
            try {
                tmp = Double.parseDouble(tab[i]);
                if (tmp>1){
                    customLogger.error("The value is greater than 1");
                    return false;
                }
            } catch (NumberFormatException e) {
                customLogger.error(e.getMessage());
                return false;
            }
            tabDouble[i - 1] = tmp;
        }
        scene.setDiffuse(tabDouble[0], tabDouble[1], tabDouble[2]);
        return true;
    }
}
