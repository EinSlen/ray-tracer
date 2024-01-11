package parsers;

import scene.Scene;

public abstract class AbstractParser {
    protected IParser iParser;
    public boolean isObjectCorrect(Scene scene, String[] tab){
        return iParser.IsCorrect(scene, tab);
    }
}
