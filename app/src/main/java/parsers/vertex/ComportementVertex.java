package parsers.vertex;

import parsers.AbstractParser;

public class ComportementVertex extends AbstractParser {
    public ComportementVertex(){
        super.iParser = new ParserVertex();
    }
}
