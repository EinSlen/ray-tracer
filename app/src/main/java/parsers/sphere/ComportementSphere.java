package parsers.sphere;

import parsers.AbstractParser;

public class ComportementSphere extends AbstractParser {
    public ComportementSphere(){
        super.iParser = new ParserSphere();
    }
}
