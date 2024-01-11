package scene;
import dev.appli.CustomLogger;

public class PictureSize {

    CustomLogger customLogger = new CustomLogger(PictureSize.class);

    /**
     * Attribut that represent the width of the picture
     */
    private int width;

    /**
     * Attribut that represent the height of the picture
     */
    private int height;


    /**
     * Constructor of the class PictureSize
     * @param width int
     * @param height int
     */
    public PictureSize(int width, int height) {
        this.width = width;
        this.height = height;
        customLogger.info(this.toString());
    }


    /**
     * Method to retrieve the value of the width
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to modify the value of the width
     * @param width int
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Method to retrieve the value of the height
     * @return int
     */

    public int getHeight() {
        return height;
    }

    /**
     * Method to modify the value of the height
     * @param height int
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method to display values of the picture
     * @return String
     */
    @Override
    public String toString() {
        return "PictureSize : " + "width = " + width + ", height = " + height ;
    }
}
