package parsers.specular;

import parsers.AbstractParser;

public class ComportementSpecular extends AbstractParser {
    public ComportementSpecular(){
        super.iParser = new ParserSpecular();
    }
}
