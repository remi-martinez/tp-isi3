package main.java.loggable;

import main.java.logger.LogColor;
import main.java.logger.LoggerUtil;

@LogColor(color = LoggerUtil.Color.ANSI_RED)
public class Person extends Loggable {
    private String firstName;

    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
