package parsers.size;

import dev.appli.CustomLogger;
import parsers.IParser;
import scene.PictureSize;
import scene.Scene;
public class ParserSize implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserSize.class);

    int []tabInt = new int[2];

    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length != 3)
            return false;
        for (int i = 1; i < tab.length; i++) {
            int tmp;
            try {
                tmp = Integer.parseInt(tab[i]);
                if(tmp<0)
                    return false;
            } catch (NumberFormatException e){
                customLogger.error(e.getMessage());
                return false;
            }
            tabInt[i-1] = tmp;
        }
        scene.setPictureSize(new PictureSize(tabInt[0],tabInt[1]));
        return true;
    }
}
