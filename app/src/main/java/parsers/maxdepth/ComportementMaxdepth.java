package parsers.maxdepth;

import parsers.AbstractParser;
public class ComportementMaxdepth extends AbstractParser {
    public ComportementMaxdepth(){
        super.iParser = new ParserMaxdepth();
    }
}
