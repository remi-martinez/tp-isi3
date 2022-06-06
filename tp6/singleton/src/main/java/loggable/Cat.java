package main.java.loggable;

import main.java.logger.LogColor;
import main.java.logger.LoggerUtil;

@LogColor(color = LoggerUtil.Color.ANSI_BLUE)
public class Cat extends Loggable {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
