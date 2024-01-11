package parsers.shadow;
import dev.appli.CustomLogger;
import parsers.IParser;
import scene.Scene;

public class ParserShadow implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserShadow.class);


    private boolean isShadow;
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=2)
            return false;
        for (int i = 1; i < tab.length; i++) {
            boolean tmp;
            try {
                tmp = Boolean.parseBoolean(tab[i]);
            } catch (NumberFormatException e){
                customLogger.error(e.getMessage());
                return false;
            }
            isShadow = tmp;
        }
        scene.setShadow(isShadow);
        return true;
    }
}
