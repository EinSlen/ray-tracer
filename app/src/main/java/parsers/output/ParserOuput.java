package parsers.output;

import dev.appli.CustomLogger;
import parsers.IParser;
import parsers.maxverts.ParserMaxverts;
import scene.Scene;

public class ParserOuput implements IParser {
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {

        if(tab.length==2){
            if(!(tab[1].matches(".*\\.png$")))
                return false;
            scene.setOutput("images/"+tab[1]);
        }
        return tab.length>=1;
    }
}
