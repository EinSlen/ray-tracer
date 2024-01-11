package decorateur;
import geometry.AObject;
import light.DirectionalLight;
import light.Light;
import scene.Scene;
import utilities.Color;
import utilities.Triplet;
import utilities.Vector;
import java.util.ArrayList;


public class PhongRenderD extends DecoRender{

    /**
     * Constructor of the class LambertRenderD
     * @param wrapper Irender
     */
    public PhongRenderD(IRender wrapper) {
        super(wrapper);
    }

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene
     * @param composite Composite
     * @return Color
     */
    public Color calculer(Composite composite) {
        Color tmp = super.calculer(composite);
        return calculate(composite.getScene(), tmp, composite.getP(), composite.getClosestObject());
    }

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene with the right parameters
     * @param scene Scene
     * @param finalColor Color
     * @param p Triplet
     * @param closestObject AObject
     * @return Color
     */
    private Color calculate(Scene scene, Color finalColor,  Triplet p, AObject closestObject){
        ArrayList<Light> lights = new ArrayList<>();
        Color objectColor = new Color(0, 0, 0);

        lights.addAll(scene.getDirectionalLights());
        lights.addAll(scene.getPonctualLights());
        for(Light light : lights) {
            boolean isShadowed = false;
            Vector shadowRayDirection;
            if(light instanceof DirectionalLight)
                shadowRayDirection = light.getVector().norm();
            else
                shadowRayDirection = light.getVector().subtract(p).norm();
            double shadowRayDistance = light.getVector().subtract(p).length();

            for (AObject shadowObject : scene.getObjects()) {
                if (shadowObject != closestObject) {
                    double shadowT = shadowObject.getIntersectionDistance(p, shadowRayDirection);
                    if (shadowT > 0 && shadowT < shadowRayDistance) {
                        isShadowed = true;
                        break;
                    }
                }
            }
            if(!isShadowed)
                return finalColor;
        }
        return objectColor;
    }
}

