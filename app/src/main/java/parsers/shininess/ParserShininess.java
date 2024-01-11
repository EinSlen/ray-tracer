package parsers.shininess;

import dev.appli.CustomLogger;
import parsers.IParser;
import scene.Scene;

public class ParserShininess implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserShininess.class);


    int tmp ;
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length>2)
            return false;
        try {
            tmp = Integer.parseInt(tab[1]);
        } catch (NumberFormatException e) {
            customLogger.error(e.getMessage());
            return false;
        }
        scene.setShininess(tmp);
        return true;
    }
}
