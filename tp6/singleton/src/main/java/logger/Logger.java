package main.java.logger;

public interface Logger {

    void log(CharSequence message);
    void log(CharSequence message, LoggerUtil.Color color);

    Logger getInstance();

}
