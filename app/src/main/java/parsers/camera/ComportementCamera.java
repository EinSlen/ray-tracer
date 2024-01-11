package parsers.camera;

import parsers.AbstractParser;

public class ComportementCamera extends AbstractParser {
    public ComportementCamera(){
        super.iParser = new ParserCamera();
    }
}
