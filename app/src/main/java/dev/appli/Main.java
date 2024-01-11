package dev.appli;

import scene.RayTracing;
import scene.Scene;

public class Main {
    /**
     * Main method of the project
     * @param args
     */
    public static void main(String[] args) {
        CustomLogger customLogger = new CustomLogger(Main.class);
        if(args.length == 1){
            customLogger.info("Launching treatments");
            Scene scene = new Scene();
            Parser parser = new Parser(scene);
            parser.readFile(args[0]);
            RayTracing rayTracing = new RayTracing(scene);
            customLogger.info("Launch rendering");
            rayTracing.render();
        } else {
            System.exit(1);
        }
    }
}
