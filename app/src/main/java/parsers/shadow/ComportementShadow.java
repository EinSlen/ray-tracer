package parsers.shadow;

import parsers.AbstractParser;
public class ComportementShadow extends AbstractParser {
    public ComportementShadow(){
        super.iParser = new ParserShadow();
    }
}
