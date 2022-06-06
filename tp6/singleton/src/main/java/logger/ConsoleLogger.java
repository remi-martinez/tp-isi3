package main.java.logger;

import java.io.PrintStream;

public class ConsoleLogger implements Logger {

    private PrintStream printStream;

    private static ConsoleLogger instance;
    public static int nbLoggable;

    public ConsoleLogger() {
        this.printStream = System.out;
    }

    private CharSequence prefixedAppend(CharSequence charSequence, LoggerUtil.Color color) {
        return String.format("%s : %s \n", toString(), LoggerUtil.coloredString(charSequence, color));
    }

    @Override
    public void log(CharSequence csq) {
        printStream.append(prefixedAppend(csq, LoggerUtil.Color.ANSI_RESET));
    }

    @Override
    public void log(CharSequence message, LoggerUtil.Color color) {
        printStream.append(prefixedAppend(message, color));
    }

    @Override
    public Logger getInstance(){
        if (instance == null) {
            instance = new ConsoleLogger();
        }
        return instance;
    }

    public static int getNbLoggable() {
        return nbLoggable;
    }

    public static void setNbLoggable(int nbLoggable) {
        System.out.println(nbLoggable);
        ConsoleLogger.nbLoggable = nbLoggable;
    }
}
