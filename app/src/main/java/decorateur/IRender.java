package decorateur;
import utilities.Color;


public interface IRender {

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene
     * @param composite Composite
     * @return Color
     */
    public Color calculer(Composite composite);
}