package OutilsPersonne;

import persons.IPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class OutilsPersonne {

    public ArrayList<IPerson> getAllPersonsAgedBetween(ArrayList<IPerson> persons, GregorianCalendar cal, int min, int max)
    {
        if (min > max) {
            throw new IllegalArgumentException("Min age should not be greater than max age");
        }

        ArrayList<IPerson> peopleList = new ArrayList<IPerson>();
        persons.forEach((IPerson p) -> {
            // Ajoute toutes les personne comprises entre ageMax et ageMin dans la liste
            if (p.getAge(cal) >= min && p.getAge(cal) <= max) {
                peopleList.add(p);
            }
        });

        return peopleList;
    }

    public int getOldestPersonFromList(ArrayList<IPerson> personList, GregorianCalendar cal)
    {
        if (personList == null || personList.isEmpty())
            return -1;

        return Collections.max(
                personList,
                Comparator.comparing((IPerson p) -> p.getAge(cal))
        ).getAge(cal);
    }


}
