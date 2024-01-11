package dev.appli;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    private final Logger logger;

    public CustomLogger(Class<?> classTmp){
        this.logger = LoggerFactory.getLogger(classTmp);
    }

    public void trace(String message){
        logger.trace(message);
    }
    public void debug(String message){
        logger.debug(message);
    }
    public void info(String message){
        logger.info(message);
    }
    public void error(String message){
        logger.error(message);
    }

}
