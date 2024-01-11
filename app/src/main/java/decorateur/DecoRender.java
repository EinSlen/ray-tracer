package decorateur;
import utilities.Color;

public class DecoRender implements IRender{

    /**
     * Attribute that represent a wrapper to implements the interface IRender
     */
    protected IRender wrapper;

    /**
     * Constructor of the class DecoRender
     * @param wrapper IRender
     */
    public DecoRender(IRender wrapper){
        this.wrapper = wrapper;
    }

    /**
     * Method that makes the necessary calculations, on the color, based on what is in the scene
     * @param composite Composite
     * @return Color
     */
    @Override
    public Color calculer(Composite composite) {
        return wrapper.calculer(composite);
    }
}