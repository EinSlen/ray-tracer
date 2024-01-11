package parsers.diffuse;

import parsers.AbstractParser;
public class ComportementDiffuse extends AbstractParser {
    public ComportementDiffuse(){
        super.iParser = new ParserDiffuse();
    }
}
