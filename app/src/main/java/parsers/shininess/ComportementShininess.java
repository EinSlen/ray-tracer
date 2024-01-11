package parsers.shininess;

import parsers.AbstractParser;

public class ComportementShininess extends AbstractParser {
    public ComportementShininess(){
        super.iParser = new ParserShininess();
    }
}
