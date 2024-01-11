package parsers.plane;

import parsers.AbstractParser;
public class ComportementPlane extends AbstractParser {
    public ComportementPlane(){
        super.iParser = new ParserPlane();
    }
}
