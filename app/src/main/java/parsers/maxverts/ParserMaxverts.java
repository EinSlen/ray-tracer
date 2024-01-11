package parsers.maxverts;

import dev.appli.CustomLogger;
import parsers.IParser;
import parsers.maxdepth.ParserMaxdepth;
import scene.Scene;

public class ParserMaxverts implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserMaxverts.class);

    int tmp;
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=2)
            return false;
        try{
            tmp = Integer.parseInt(tab[1]);
        }
        catch (NumberFormatException e){
            customLogger.error(e.getMessage());
            return false;
        }
        scene.setNbPoint(tmp);
        return true;
    }
}
