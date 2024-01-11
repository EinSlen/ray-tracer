package decorateur;
import geometry.AObject;
import geometry.Plane;
import light.DirectionalLight;
import light.PonctualLight;
import scene.Scene;
import utilities.Color;
import utilities.Triplet;
import utilities.Vector;


public class LambertRenderD extends DecoRender{

    /**
     * Constructor of the class LambertRenderD
     * @param wrapper Irender
     */
    public LambertRenderD(IRender wrapper) {
        super(wrapper);
    }


    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene
     * @param composite Composite
     * @return Color
     */
    public Color calculer(Composite composite) {
        Color tmp = super.calculer(composite);
        return calculate(composite.getScene(), tmp, composite.getN(), composite.getP(), composite.getClosestObject());
    }

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene with the right parameters
     * @param scene Scene
     * @param finalColor Color
     * @param n Vector
     * @param p Triplet
     * @param closestObject AObject
     * @return Color
     */
    private Color calculate(Scene scene, Color finalColor, Vector n,  Triplet p, AObject closestObject){
        Color objectColor = closestObject.getColor();
        if(!scene.getDirectionalLights().isEmpty()) {
            for (DirectionalLight light : scene.getDirectionalLights()) {
                finalColor = finalColor.add(addiffuseContribution(light, n, objectColor));
            }
        }
        if(!scene.getPonctualLights().isEmpty()){
            for (PonctualLight light : scene.getPonctualLights()) {
                finalColor = finalColor.add(addPonctualLightContribution(light, p, n, objectColor));
            }
        }

        if(scene.getChecker() != null) {
            finalColor = addColorFromChecker(scene, p, closestObject, finalColor);
        }
        return finalColor;
    }

    /**
     * Method to add a diffuse color
     * @param light DirectionalLight
     * @param n Vector
     * @param sphereColor Color
     * @return Triplet
     */
    private Triplet addiffuseContribution(DirectionalLight light, Vector n, Color sphereColor) {
        Vector lightDirection = light.getVector().norm();
        double cosTheta = Math.max(n.scalarProduct(lightDirection.getTriplet()), 0); // Réflexion diffuse de Lambert
        Color diffuseContribution = light.getColor().multiply(cosTheta).schurProduct(sphereColor.getTriplet()); // Multiplication de couleur

        return diffuseContribution.getTriplet();
    }

    /**
     * Method to add a ponctual light
     * @param light PonctualLight
     * @param p Triplet
     * @param n Vector
     * @param objectColor Color
     * @return Triplet
     */
    private Triplet addPonctualLightContribution(PonctualLight light, Triplet p, Vector n, Color objectColor) {
        Vector lightDirection = new Vector(light.getPosition().subtract(p)).norm();
        double cosTheta = Math.max(n.scalarProduct(lightDirection.getTriplet()), 0); // Réflexion diffuse de Lambert
        Color diffuseContribution = light.getColor().multiply(cosTheta).schurProduct(objectColor.getTriplet()); // Multiplication de couleur
        return diffuseContribution.getTriplet();
    }

    /**
     * Method that add a color
     * @param scene Scene
     * @param p Triplet
     * @param closestObject AObject
     * @param finalColor Color
     * @return Color
     */
    private Color addColorFromChecker(Scene scene, Triplet p, AObject closestObject, Color finalColor) {
        if(closestObject instanceof Plane) {
            Color checkerColor = scene.getChecker().getColorAtPoint(p.getX(), p.getY(), p.getZ());
            return finalColor.schurProduct(checkerColor.getTriplet());
        }
        return finalColor;
    }

}