package parsers.point;

import parsers.AbstractParser;
public class ComportementPoint extends AbstractParser {
    public ComportementPoint(){
        super.iParser = new ParserPoint();
    }
}
