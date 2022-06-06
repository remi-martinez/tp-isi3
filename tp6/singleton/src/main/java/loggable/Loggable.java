package main.java.loggable;

import main.java.logger.ConsoleLogger;
import main.java.logger.LogColor;
import main.java.logger.Logger;

public abstract class Loggable {

    private Logger logger = new ConsoleLogger();

    public void log() {
        LogColor c = this.getClass().getAnnotation(LogColor.class);
        logger.log(toString(), c.color());
        ConsoleLogger.setNbLoggable(ConsoleLogger.getNbLoggable() + 1);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
