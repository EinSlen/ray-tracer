package decorateur;

import geometry.AObject;
import scene.Scene;
import utilities.Triplet;
import utilities.Vector;

public class Composite {

    /**
     * Attribute that represents the scene
     */
    private Scene scene;

    /**
     * Attribute that represents a vector n
     */
    private Vector n;

    /**
     * Attribute that represents a Triplet p
     */
    private Triplet p;

    /**
     * Attribute that represents an object
     */
    private AObject closestObject;

    /**
     * Attribute that represents eye position for the camera
     */
    private Triplet lookFrom;

    /**
     * Attribute that represents a vector d
     */
    private Vector d;
    private double closestT;

    /**
     * Constructor of the class Composite
     * @param scene Scene
     * @param p Triplet
     * @param closestObject AObject
     * @param lookFrom Triplet
     * @param d Vector
     * @param closestT double
     */
    public Composite(Scene scene, Triplet p, AObject closestObject, Triplet lookFrom, Vector d, double closestT) {
        this.scene = scene;
        this.p = p;
        this.closestObject = closestObject;
        this.lookFrom = lookFrom;
        this.d = d;
        this.closestT = closestT;
    }

    /**
     * Method that retrieve the scene
     * @return Scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Method that modify the scene
     * @param scene Scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Method to retrieve the value of the vector n
     * @return Vector
     */
    public Vector getN() {
        return n;
    }

    /**
     * Method that modify the value of the vector n
     * @param n Vector
     */
    public void setN(Vector n) {
        this.n = n;
    }

    /**
     * Method to retrieve the value of the triplet p
     * @return Triplet
     */
    public Triplet getP() {
        return p;
    }

    /**
     * Method that modify the value of the triplet p
     * @param p Triplet
     */
    public void setP(Triplet p) {
        this.p = p;
    }

    /**
     * Method to retrieve the value of the object
     * @return AObject
     */
    public AObject getClosestObject() {
        return closestObject;
    }

    /**
     * Method to modify the value of the object
     * @param closestObject AObject
     */
    public void setClosestObject(AObject closestObject) {
        this.closestObject = closestObject;
    }

    /**
     * Method to retrieve the value of eye position
     * @return Triplet
     */
    public Triplet getLookFrom() {
        return lookFrom;
    }

    /**
     * Method to modify the value of eye position
     * @param lookFrom Triplet
     */
    public void setLookFrom(Triplet lookFrom) {
        this.lookFrom = lookFrom;
    }

    /**
     * Method to retrieve the value of the vector d
     * @return Vector
     */
    public Vector getD() {
        return d;
    }

    /**
     * Method to modify the value of the vector d
     * @param d vector
     */
    public void setD(Vector d) {
        this.d = d;
    }

    /**
     * Method to retrieve the value of closestT
     * @return double
     */
    public double getClosestT() {
        return closestT;
    }

    /**
     * Method that modify the value of the double closestT
     * @param closestT double
     */
    public void setClosestT(double closestT) {
        this.closestT = closestT;
    }
}
