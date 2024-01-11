package parsers.tri;

import parsers.AbstractParser;

public class ComportementTri extends AbstractParser {
    public ComportementTri(){
        super.iParser = new parsers.tri.ParserTri();
    }
}
