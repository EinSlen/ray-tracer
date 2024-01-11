
package dev.appli;

import parsers.AbstractParser;
import parsers.ambient.ComportementAmbient;
import parsers.camera.ComportementCamera;
import parsers.checker.ComportementChecker;
import parsers.diffuse.ComportementDiffuse;
import parsers.maxdepth.ComportementMaxdepth;
import parsers.maxverts.ComportementMaxverts;
import parsers.output.ComportementOutput;
import parsers.plane.ComportementPlane;
import parsers.point.ComportementPoint;
import parsers.shadow.ComportementShadow;
import parsers.shininess.ComportementShininess;
import parsers.size.ComportementSize;
import parsers.specular.ComportementSpecular;
import parsers.sphere.ComportementSphere;
import parsers.tri.ComportementTri;
import parsers.vertex.ComportementVertex;
import scene.Scene;
import parsers.directional.ComportementDirectional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    /**
     * Attribute that represents the scene
     */
    CustomLogger customLogger = new CustomLogger(Parser.class);
    /**
     * Create a map
     */
    private final Scene scene;

    Map<String, AbstractParser> keyWords = new HashMap<>();

    /**
     * Constructor of the class Parser
     * @param scene Scene
     */
    public Parser(Scene scene) {
        customLogger.info("Create parsers");
        this.scene = scene;
        keyWords.put("size", new ComportementSize());
        keyWords.put("output",new ComportementOutput());
        keyWords.put("camera",new ComportementCamera());
        keyWords.put("ambient", new ComportementAmbient());
        keyWords.put("diffuse", new ComportementDiffuse());
        keyWords.put("specular", new ComportementSpecular());
        keyWords.put("shininess", new ComportementShininess());
        keyWords.put("directional", new ComportementDirectional());
        keyWords.put("point", new ComportementPoint());
        keyWords.put("maxverts", new ComportementMaxverts()) ;
        keyWords.put("vertex", new ComportementVertex());
        keyWords.put("tri", new ComportementTri());
        keyWords.put("sphere", new ComportementSphere());
        keyWords.put("plane", new ComportementPlane());
        keyWords.put("shadow", new ComportementShadow());
        keyWords.put("maxdepth", new ComportementMaxdepth());
        keyWords.put("checker", new ComportementChecker());
    }
    /**
     * Method to read the file in the parameter
     * @param fileName String
     */
    public void readFile(String fileName){
        String []list;
        try{
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String line;
            while((line = bReader.readLine())!=null){
                if(!(line.isEmpty()) && (line.charAt(0) != '#')){
                        list = line.trim().split("\\s+");
                        isCorrect(list);
                }
            }
            bReader.close();
            reader.close();
        } catch(IOException e){
            customLogger.error(e.getMessage());
        }
    }

    /**
     * Method that checks the file and create an object of this line in the scene
     * @param tab String[]
     * @return boolean
     */
    private void isCorrect(String[] tab){
        boolean res = false;
        if(keyWords.containsKey(tab[0])){
            res = keyWords.get(tab[0]).isObjectCorrect(scene, tab);
            customLogger.info(String.valueOf(res));
        }
    }


}


