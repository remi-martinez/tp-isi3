package main.java.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Very very dumb file logger, do not copy this logger in your project.
 */
public class FileLogger implements Logger {


    public FileLogger() {

    }

    public static int nbLoggable;
    public static FileLogger instance;

    @Override
    public void log(CharSequence message) {
        try {
            FileWriter fileWriter = new FileWriter("tmp.txt", true);
            fileWriter.write((String) message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(CharSequence message, LoggerUtil.Color color) {
        this.log(message);
    }

    @Override
    public Logger getInstance(){
        if (instance == null) {
            instance = new FileLogger();
        }
        return instance;
    }

    public static int getNbLoggable() {
        return nbLoggable;
    }

    public static void setNbLoggable(int nbLoggable) {
        ConsoleLogger.nbLoggable = nbLoggable;
    }
}
