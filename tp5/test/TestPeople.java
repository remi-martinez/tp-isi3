import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;
import people.AgainAnotherPerson;
import people.AnotherPerson;
import people.OneMorePerson;
import people.SimplePerson;
import persons.IPerson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class TestPeople {
    @Parameterized.Parameters
    public static Collection<IPerson> GetAllPersonClasses() {
        ArrayList<IPerson> list = new ArrayList<IPerson>();
        list.add(new AgainAnotherPerson("MARTINEZ","Rémi",2000,2,8));
        list.add(new AnotherPerson("MARTINEZ","Rémi",2000,2,8));
        list.add(new OneMorePerson("MARTINEZ","Rémi",2000,2,8));
        list.add(new SimplePerson("MARTINEZ","Rémi",2000,2,8));
        return list;
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne est bien née le jour de sa naissance")
    public void wasBorn_returns_true_same_day(IPerson person){
        // When
        GregorianCalendar birthDate = new GregorianCalendar(2000, Calendar.FEBRUARY,8);

        // Then
        assertTrue(person.wasBorn(birthDate));
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne n'est pas encore née un jour avant sa naissance")
    public void wasBorn_returns_false_one_day_before_birth(IPerson person) {
        // When
        GregorianCalendar oneDayBefore = new GregorianCalendar(2000, Calendar.FEBRUARY,7);

        // Then
        assertFalse(person.wasBorn(oneDayBefore));
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne est déjà née un jour après sa naissance")
    public void wasBorn_returns_true_one_day_after_birth(IPerson person) {
        // When
        GregorianCalendar oneDayAfter = new GregorianCalendar(2000, Calendar.FEBRUARY,9);

        // Then
        assertTrue(person.wasBorn(oneDayAfter));
    }


    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne n'est pas encore née un mois avant sa naissance")
    public void wasBorn_returns_false_one_month_before_birth(IPerson person) {
        // When
        GregorianCalendar oneMonthBefore = new GregorianCalendar(2000, Calendar.JANUARY,8);

        // Then
        assertFalse(person.wasBorn(oneMonthBefore));
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne est déjà née un mois après sa naissance")
    public void wasBorn_returns_true_one_month_after_birth(IPerson person) {
        // When
        GregorianCalendar oneMonthAfter = new GregorianCalendar(2000, Calendar.MARCH,8);

        // Then
        assertTrue(person.wasBorn(oneMonthAfter));
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne n'est pas encore née un an avant sa naissance")
    public void wasBorn_returns_false_one_year_before_birth(IPerson person) {
        // When
        GregorianCalendar oneYearBefore = new GregorianCalendar(1999, Calendar.JANUARY,8);

        // Then
        assertFalse(person.wasBorn(oneYearBefore));
    }


    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne est déjà née un an après sa naissance")
    public void wasBorn_returns_true_one_year_after_birth(IPerson person) {
        // When
        GregorianCalendar oneYearAfter = new GregorianCalendar(2001, Calendar.FEBRUARY,8);

        // Then
        assertTrue(person.wasBorn(oneYearAfter));
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("L'âge de la personne est correcte")
    public void getAge_returns_age(IPerson person){
        // Given
        int expectedAge = 22;

        // When
        int actualAge = person.getAge(new GregorianCalendar(2022,Calendar.APRIL,29));

        // Then
        assertEquals(expectedAge, actualAge);
    }


    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne a 0 an le jour de sa naissance")
    public void getAge_equals_0_on_birthDate(IPerson person) {
        // Given
        int expectedAge = 0;

        // When
        int actualAge = person.getAge(new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // Then
        assertEquals(expectedAge, actualAge);
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne n'a pas encore changé d'âge la veille de son anniversaire")
    public void getAge_day_before_birthDate(IPerson person) {
        // Given
        int expectedAge = 4;

        // When
        int actualAge = person.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,7));

        // Then
        assertEquals(expectedAge, actualAge);
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("La personne a changé d'âge le jour et le lendemain de son anniversaire")
    public void getAge_after_birthDate(IPerson person) {
        // Given
        int expectedAgeOnBirthdate = 5;
        int expectedAgeDayAfterBirthDate = 5;

        // When
        int actualAgeOnBirthDate = person.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,8));
        int actualAgeAfterBirthDate = person.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,9));

        // Then
        assertEquals(expectedAgeOnBirthdate, actualAgeOnBirthDate);
        assertEquals(expectedAgeDayAfterBirthDate, actualAgeAfterBirthDate);
    }

    @ParameterizedTest
    @MethodSource("GetAllPersonClasses")
    @DisplayName("L'âge retourne une erreur si la personne n'est pas encore née")
    public void getAge_notBorn_returns_error(IPerson person) {
        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            person.getAge(new GregorianCalendar(1990, Calendar.FEBRUARY,8));
        });

        // Then
        assertEquals("Cannot compute age before birth", exception.getMessage());

    }
}
