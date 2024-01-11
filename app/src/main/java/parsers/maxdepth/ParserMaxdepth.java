package parsers.maxdepth;


import dev.appli.CustomLogger;
import parsers.IParser;
import parsers.directional.ParserDirectional;
import scene.Scene;

public class ParserMaxdepth implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserMaxdepth.class);

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
        scene.setMaxdepth(tmp);
        return true;
    }
}
