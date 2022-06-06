package main.java;

import main.java.loggable.Cat;
import main.java.loggable.Loggable;
import main.java.loggable.Person;
import main.java.logger.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanFactory beanFactory = (BeanFactory)context;

        System.out.println(beanFactory.getBean("logger"));
        System.out.println(beanFactory.getBean("logger"));
        System.out.println(beanFactory.getBean("logger"));

        List<Loggable> loggableList = new ArrayList<>();

        loggableList.add(new Person("Antoine", "Caron"));
        loggableList.add(new Person("Philippe", "Charrière"));
        loggableList.add(new Cat("Garfield"));
        loggableList.add(new Person("Christine", "Gertosio"));
        loggableList.add(new Person("Christian", "Vial"));
        loggableList.add(new Cat("Felix"));
        loggableList.add(new Person("Laetitia", "Matignon"));

        loggableList.forEach(Loggable::log);

        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);

        Cat cat = beanFactory.getBean(Cat.class);
        System.out.println(cat);

//        Person p = new Person("test", "test");
//        Logger l = p.getLogger().getInstance();
//
//        if(l instanceof ConsoleLogger){
//            System.out.println("Nombre de loggable : " + ConsoleLogger.getNbLoggable());
//        }else if(l instanceof FileLogger){
//            System.out.println("Nombre de loggable : " + FileLogger.getNbLoggable());
//        }
    }
}
