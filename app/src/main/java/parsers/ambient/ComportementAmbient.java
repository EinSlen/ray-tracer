package parsers.ambient;

import parsers.AbstractParser;
public class ComportementAmbient extends AbstractParser {
    public ComportementAmbient(){
        super.iParser= new ParserAmbient();
    }
}
