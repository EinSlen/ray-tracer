package scene;
import dev.appli.CustomLogger;
import geometry.textures.CheckerboardTexture;
import light.DirectionalLight;
import light.PonctualLight;
import geometry.AObject;
import utilities.Color;
import utilities.Point;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private final CustomLogger customLogger = new CustomLogger(Scene.class);

    /**
     * Attribute representing the cameras present in the main.java.scene
     */
    private Camera camera;

    /**
     * Attribute representing the sizes of the pictures present in the main.java.scene
     */
    private PictureSize picture;

    /**
     * Attribute representing objects in the main.java.scene
     */

    private final ArrayList<AObject> objects;

    /**
     * Attribute representing point in the scene
     */
    private ArrayList<Point> points;


    /**
     * Attribute representing punctual lights in the scene
     */
    private final ArrayList<PonctualLight> ponctualLights;

    /**
     * Attribute representing directional lights in the scene
     */
    private final ArrayList<DirectionalLight> directionalLights;

    /**
     * Attribute representing the output of the picture
     */
    private String output;

    /**
     * Attribute representing the number of point in the scene
     */
    private int nbPoints;

    /**
     * Attribute representing the ambient color
     */
    private Color ambient;

    /**
     * Attribute representing the diffuse color
     */
    private Color diffuse;

    /**
     * Attribute representing the shadow in the scene
     */
    private boolean shadow;

    /**
     * Attribute representing the maximal value of the depth parameter
     */
    private int maxdepth;

    /**
     * Attribute representing the brilliance of the object
     */
    private int shininess;

    /**
     * Attribute representing the texture of the object
     */
    private CheckerboardTexture checker;

    /**
     * Attribute representing the specular color
     */
    private Color specular;


    /**
     * Constructor of the class Scene
     */
    public Scene() {
        customLogger.info("Create scene");
        this.camera = null;
        this.picture = null;
        this.objects = new ArrayList<>();
        this.points = new ArrayList<>();
        this.output = "output.png";
        this.nbPoints = 0;
        this.ponctualLights = new ArrayList<>();
        this.directionalLights = new ArrayList<>();
        this.ambient = new Color(1, 1, 1);
        this.diffuse = new Color(1, 0, 0);
        this.shadow = false;
        this.maxdepth = 10;
        this.checker = null;
        this.specular = null;
    }

    /**
     * Method that retrieves the list of cameras present in the main.java.scene
     * @return ArrayList<Camera>
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Method that adds a camera to the main.java.scene
     * @param camera
     */
    public void addCamera(Camera camera) {
        this.camera = camera;
        customLogger.info("add camera to scene");
    }


    /**
     * Method that retrieves the list of the pictures size
     *
     * @return ArrayList<PictureSize>
     */
    public scene.PictureSize getPicture() {
        return picture;
    }

    /**
     * Methods to modify the value of the shadow
     * @param shadow boolean
     */
    public void setShadow(boolean shadow) {
        this.shadow = shadow;
        customLogger.info("set shadow to scene");
    }

    /**
     * Method to retrieve the value of the depth parameter
     * @return int
     */
    public int getMaxdepth() {
        return maxdepth;
    }


    /**
     * Method to modify the value of the depth parameter
     * @param maxdepth int
     */
    public void setMaxdepth(int maxdepth) {
        this.maxdepth = maxdepth;
        customLogger.info("set max-depth to scene");
    }

    /**
     * Method to retrieve the value of the brilliance of the object
     * @return int
     */
    public int getShininess() {
        return shininess;
    }

    /**
     * Method to modify the value of the brilliance of the object
     * @param shininess int
     */
    public void setShininess(int shininess) {
        this.shininess = shininess;
        customLogger.info("set shininess to scene");
    }

    /**
     * Method that adds a picture size
     * @param pictureSize
     */
    public void setPictureSize(PictureSize pictureSize) {
        this.picture = pictureSize;
        customLogger.info("set pictureSize to scene");
    }




    /**
     * Method to retireve the value of the ponctual lights
     * @return ArrayList<PonctualLights>
     */
    public List<PonctualLight> getPonctualLights() {
        return ponctualLights;
    }

    /**
     * Method to retrieve the value of the ambient color
     * @return Color
     */
    public Color getAmbient() {
        return ambient;
    }

    /**
     * Method to modify the value of the ambient color
     * @param r double
     * @param g double
     * @param b double
     */
    public void setAmbient(double r, double g, double b) {
        this.ambient = new Color(r, g, b);
        customLogger.info("set ambient to scene");
    }

    /**
     * Method to retrieve the value of the diffuse color
     * @return Color
     */
    public Color getDiffuse() {
        return diffuse;
    }

    /**
     * Metjod to modify the value of the diffuse color
     * @param r double
     * @param g double
     * @param b double
     */
    public void setDiffuse(double r, double g, double b) {
        this.diffuse = new Color(r, g, b);
        customLogger.info("set diffuse to scene");
    }

    /**
     * Method to retrieve the value of the specular color
     * @return Color
     */
    public Color getSpecular() {
        return specular;
    }

    /**
     * Method to modify the value of the specular color
     * @param specular Color
     */
    public void setSpecular(Color specular) {
        this.specular = specular;
                customLogger.info("set specular to scene");
    }

    /**
     * Method to retrieve the value of the texture
     * @return CheckerboardTexture
     */
    public CheckerboardTexture getChecker() {
        return checker;
    }

    /**
     * Method to modify the value of the texture
     * @param checker CheckerboardTexture
     */
    public void setChecker(CheckerboardTexture checker) {
        this.checker = checker;
        customLogger.info("set checker to scene");
    }

    /**
     * Method to add a ponctual light in the scene
     * @param ponctualLights PonctualLight
     */
    public void addPonctualLights(PonctualLight ponctualLights) {
        this.ponctualLights.add(ponctualLights);
        customLogger.info("add punctualLights to scene");
    }

    /**
     * Method to retrieve the value of the lis of directional lights
     * @return ArrayList<DirectionalLight>
     */
    public List<DirectionalLight> getDirectionalLights() {
        return directionalLights;

    }

    /**
     * Method to add a direction light in the scene
     * @param directionalLights DirectionalLight
     */
    public void addDirectionalLights(DirectionalLight directionalLights) {
        this.directionalLights.add(directionalLights);
        customLogger.info("add directionalLights to scene");
    }

    /**
     * Method to know if there is shadow in the scene or not
     * @return boolean
     */
    public boolean isShadow() {
        return shadow;
    }

    /**
     * Method that retrieves the list of objects present in the main.java.scene
     * @return ArrayList<AObject>
     */

    public List<AObject> getObjects() {
        return objects;
    }


    /**
     * Method that adds an object to the scene
     * @param object AObject
     */
    public void addObjects(AObject object) {
        this.objects.add(object);
        customLogger.info("add object to scene");
    }


    /**
     * Method that retrieves the list of points present in the scene
     * @return List<Point>
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Method that adds a point
     * @param point
     */
    public void setPoints(ArrayList<Point> point) {
        this.points = point;
    }


    /**
     * Method to retrieve the value of the output of the picture
     * @return String
     */
    public String getOutput() {
        return output;
    }


    /**
     * Method to modify the value of the output
     * @param output String
     */
    public void setOutput(String output) {
        this.output = output;
        customLogger.info("set output to scene");
    }

    /**
     * Method to modify the number of point in the scene
     * @param tmp int
     */
    public void setNbPoint(int tmp) {
        this.nbPoints = tmp;
    }

    /**
     * Method to retrieve the number of point in the scene
     * @return int
     */
    public int getNbPoints() {
        return nbPoints;
    }
}

