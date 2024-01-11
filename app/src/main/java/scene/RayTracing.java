package scene;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import decorateur.*;
import decorateur.Composite;
import dev.appli.CustomLogger;
import geometry.AObject;
import utilities.Triplet;
import utilities.Vector;
import utilities.Color;
import javax.imageio.ImageIO;

public class RayTracing {
    private final CustomLogger customLogger = new CustomLogger(RayTracing.class);
    private final Scene scene;
    private final BufferedImage image;
    private final Color[][] colors;

    public RayTracing(Scene scene){
        customLogger.info("Create raytracing");
        this.scene = scene;
        this.image = new BufferedImage(scene.getPicture().getWidth(),scene.getPicture().getHeight(), BufferedImage.TYPE_INT_RGB);
        this.colors = new Color[scene.getPicture().getWidth()][scene.getPicture().getHeight()];
    }

    public void render() throws UnsupportedOperationException {
        Triplet lookFrom = scene.getCamera().getLookFrom();
        Triplet lookAt = scene.getCamera().getLookAt();
        double fovr = ((scene.getCamera().getField()*Math.PI)/180);
        double realHeight = 2 * Math.tan(fovr / 2);
        double pixelHeight = realHeight / scene.getPicture().getHeight();
        double realWidth = scene.getPicture().getWidth() * pixelHeight;
        double pixelWidth = realWidth / scene.getPicture().getWidth();
        Vector up = new Vector(scene.getCamera().getUp());
        Vector w = new Vector(lookFrom.subtract(lookAt)).multiply(1/lookFrom.subtract(lookAt).length());
        Vector u = (up.vectorProduct(w.getTriplet())).multiply(1 / up.vectorProduct(w.getTriplet()).length());
        Vector v = (w.vectorProduct(u.getTriplet())).multiply(1 / w.vectorProduct(u.getTriplet()).length());
        for (int i = 0; i < scene.getPicture().getWidth(); i++) {
            for (int j = 0; j < scene.getPicture().getHeight(); j++) {
                double a = -(realWidth / 2) + (i + 0.5) * pixelWidth;
                double b = (realHeight / 2) - (j + 0.5) * pixelHeight;
                Vector d = calculateRayDirection(a, b, u, v, w);


                Color finalColor = new Color(0,0,0);
                double closestT = Double.POSITIVE_INFINITY;
                AObject closestObject = null;

                for (AObject object : scene.getObjects()) {
                    double t = object.getIntersectionDistance(lookFrom, d);
                    if (t > 0 && t < closestT) {
                        closestT = t;
                        closestObject = object;
                    }
                }

                if (closestObject != null) {
                    Triplet p = lookFrom.add(d.multiply(closestT).getTriplet());
                    Composite composite = new Composite(scene,p,closestObject,lookFrom,d,closestT);
                    IRender base = new BaseRenderD();
                    finalColor = base.calculer(composite);
                    if(!scene.getDirectionalLights().isEmpty() || !scene.getPonctualLights().isEmpty()){
                        if(!scene.isShadow()) {
                            finalColor = new LambertRenderD(base).calculer(composite);
                        } else {
                            IRender phong = new PhongRenderD(new LambertRenderD(base));
                            finalColor = phong.calculer(composite);
                        }
                    }

                }

                colors[i][j] = finalColor;
            }
        }
        createImg(colors);
    }

    private Vector calculateRayDirection(double a, double b, Vector u, Vector v, Vector w) {
        return u.multiply(a).add(v.multiply(b).subtract(w.getTriplet()).getTriplet()).multiply(1 / u.multiply(a).add(v.multiply(b).subtract(w.getTriplet()).getTriplet()).length());
    }

    public void createImg(Color[][] colors) {
        try {
            for (int i = 0; i < scene.getPicture().getWidth(); i++) {
                for (int j = 0; j < scene.getPicture().getHeight(); j++) {
                    int red = (int) (colors[i][j].getR() * 255);
                    int green = (int) (colors[i][j].getG() * 255);
                    int blue = (int) (colors[i][j].getB() * 255);
                    int rgb = (red << 16) | (green << 8) | blue;
                    image.setRGB(i, j, rgb);
                }
            }
            File outputfile = new File(scene.getOutput());
            ImageIO.write(image, "png", outputfile);
            customLogger.info("IMAGE GENERATE : " + scene.getOutput());
        } catch (IOException e) {
            customLogger.error(e.getMessage());
        }
    }
}
