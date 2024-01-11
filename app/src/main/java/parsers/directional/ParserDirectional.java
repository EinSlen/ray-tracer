package parsers.directional;
import dev.appli.CustomLogger;
import light.DirectionalLight;
import parsers.IParser;
import scene.Scene;
import utilities.Color;
import utilities.Triplet;
import utilities.Vector;



public class ParserDirectional implements IParser {
    private final CustomLogger customLogger = new CustomLogger(ParserDirectional.class);

    Double []tabDouble = new Double[6];
    @Override
    public boolean IsCorrect(Scene scene, String[] tab) {
        if(tab.length!=7)
            return false;
        for (int i = 1; i < tab.length; i++) {
            double tmp;
            try {
                tmp = Double.parseDouble(tab[i]);
            } catch (NumberFormatException e){
                customLogger.error(e.getMessage());
                return false;
            }
            tabDouble[i-1] = tmp;
        }
        Vector vector = new Vector(tabDouble[0],tabDouble[1],tabDouble[2]);
        Color color = new Color(new Triplet(tabDouble[3],tabDouble[4],tabDouble[5]));
        DirectionalLight directionalLight = new DirectionalLight(vector, color);
        scene.addDirectionalLights(directionalLight);
        return true;
    }
}
