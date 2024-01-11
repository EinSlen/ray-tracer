package parsers.checker;

import parsers.AbstractParser;

public class ComportementChecker extends AbstractParser {
    public ComportementChecker(){
        super.iParser = new ParserChecker();
    }
}
