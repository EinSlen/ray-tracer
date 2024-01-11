package decorateur;
import geometry.AObject;
import geometry.Plane;
import geometry.Triangles;
import scene.Scene;
import utilities.Color;
import utilities.Triplet;

public class BaseRenderD implements IRender {
    /**
     * Attribute that represent the final color
     */
    private Color finalColor;

    /**
     * Constructor of the class BaseRenderD
     */
    public BaseRenderD() {
        this.finalColor = new Color(0, 0, 0);
    }

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene
     * @param composite Composite
     * @return Color
     */
    public Color calculer(Composite composite) {
        Color objectColor = composite.getClosestObject().getColor();
        composite.setN(composite.getClosestObject().getNormal(composite.getP()));

        if (composite.getScene().getDirectionalLights().isEmpty() && composite.getScene().getPonctualLights().isEmpty()) {
            this.finalColor = objectColor;
        }

        if (composite.getClosestObject() instanceof Triangles) {
            this.finalColor = objectColor;
        }

        if (composite.getScene().getChecker() != null) {
            finalColor = addColorFromChecker(composite.getScene(), composite.getP(), composite.getClosestObject(), finalColor);

        }
        return this.finalColor;
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
        if (closestObject instanceof Plane) {
            Color checkerColor = scene.getChecker().getColorAtPoint(p.getX(), p.getY(), p.getZ());
            return finalColor.schurProduct(checkerColor.getTriplet());
        }
        return finalColor;
    }
}
