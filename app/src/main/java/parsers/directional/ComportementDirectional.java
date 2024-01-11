package parsers.directional;

import parsers.AbstractParser;
public class ComportementDirectional extends AbstractParser {
    public ComportementDirectional(){
        super.iParser = new parsers.directional.ParserDirectional();
    }
}
