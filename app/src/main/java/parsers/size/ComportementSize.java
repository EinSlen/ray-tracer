package parsers.size;

import parsers.AbstractParser;

public class ComportementSize extends AbstractParser {
    public ComportementSize(){
        super.iParser = new ParserSize();
    }
}
