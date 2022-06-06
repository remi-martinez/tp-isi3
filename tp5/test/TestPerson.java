
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persons.IPerson;
import persons.Person;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerson {


    @Test
    @DisplayName("La personne instanciée à le bon prénom et nom")
    public void ctor_givenName(){
        // Given
        String exceptedFirstName = "Bob";
        String exceptedLastName = "Dylan";
        IPerson testPerson = new Person(exceptedLastName, exceptedFirstName, new GregorianCalendar());

        // When
        String actualFirstName = testPerson.getFirstName();
        String actualLastName = testPerson.getName();

        // Then
        assertEquals(exceptedFirstName, actualFirstName);
        assertEquals(exceptedLastName, actualLastName);
    }

    // wasBorn

    @Test
    @DisplayName("La personne est bien née le jour de sa naissance")
    public void wasBorn_returns_true_same_day() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar birthDate = new GregorianCalendar(2000, Calendar.FEBRUARY,8);

        // Then*
        assertTrue(testPerson.wasBorn(birthDate));

    }

    @Test
    @DisplayName("La personne est bien née avec une date de naissance antérieure à aujourd'hui")
    public void wasBorn_returns_true_after_birthdate() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar today = new GregorianCalendar();

        // Then
        assertTrue(testPerson.wasBorn(today));
    }

    @Test
    @DisplayName("La personne n'est pas encore née un jour avant sa naissance")
    public void wasBorn_returns_false_one_day_before_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneDayBefore = new GregorianCalendar(2000, Calendar.FEBRUARY,7);

        // Then
        assertFalse(testPerson.wasBorn(oneDayBefore));
    }

    @Test
    @DisplayName("La personne est déjà née un jour après sa naissance")
    public void wasBorn_returns_true_one_day_after_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneDayAfter = new GregorianCalendar(2000, Calendar.FEBRUARY,9);

        // Then
        assertTrue(testPerson.wasBorn(oneDayAfter));
    }

    @Test
    @DisplayName("La personne n'est pas encore née un mois avant sa naissance")
    public void wasBorn_returns_false_one_month_before_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneMonthBefore = new GregorianCalendar(2000, Calendar.JANUARY,8);

        // Then
        assertFalse(testPerson.wasBorn(oneMonthBefore));
    }

    @Test
    @DisplayName("La personne est déjà née un mois après sa naissance")
    public void wasBorn_returns_true_one_month_after_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneMonthAfter = new GregorianCalendar(2000, Calendar.MARCH,8);

        // Then
        assertTrue(testPerson.wasBorn(oneMonthAfter));
    }

    @Test
    @DisplayName("La personne n'est pas encore née un an avant sa naissance")
    public void wasBorn_returns_false_one_year_before_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneYearBefore = new GregorianCalendar(1999, Calendar.JANUARY,8);

        // Then
        assertFalse(testPerson.wasBorn(oneYearBefore));
    }


    @Test
    @DisplayName("La personne est déjà née un an après sa naissance")
    public void wasBorn_returns_true_one_year_after_birth() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        GregorianCalendar oneYearAfter = new GregorianCalendar(2001, Calendar.FEBRUARY,8);

        // Then
        assertTrue(testPerson.wasBorn(oneYearAfter));
    }

    // getAge

    @Test
    @DisplayName("L'âge de la personne est correcte")
    public void getAge_returns_age(){
        // Given
        int expectedAge = 22;
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        int actualAge = testPerson.getAge(new GregorianCalendar(2022,Calendar.APRIL,29));

        // Then
        assertEquals(expectedAge, actualAge);
    }

    @Test
    @DisplayName("La personne a 0 an le jour de sa naissance")
    public void getAge_equals_0_on_birthDate() {
        // Given
        int expectedAge = 0;
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        int actualAge = testPerson.getAge(new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // Then
        assertEquals(expectedAge, actualAge);
    }

    @Test
    @DisplayName("La personne n'a pas encore changé d'âge la veille de son anniversaire")
    public void getAge_day_before_birthDate() {
        // Given
        int expectedAge = 4;
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        int actualAge = testPerson.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,7));

        // Then
        assertEquals(expectedAge, actualAge);
    }

    @Test
    @DisplayName("La personne a changé d'âge le jour et le lendemain de son anniversaire")
    public void getAge_after_birthDate() {
        // Given
        int expectedAgeOnBirthdate = 5;
        int expectedAgeDayAfterBirthDate = 5;
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        int actualAgeOnBirthDate = testPerson.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,8));
        int actualAgeAfterBirthDate = testPerson.getAge(new GregorianCalendar(2005, Calendar.FEBRUARY,9));

        // Then
        assertEquals(expectedAgeOnBirthdate, actualAgeOnBirthDate);
        assertEquals(expectedAgeDayAfterBirthDate, actualAgeAfterBirthDate);
    }

    @Test
    @DisplayName("L'âge retourne une erreur si la personne n'est pas encore née")
    public void getAge_notBorn_returns_error() {
        // Given
        IPerson testPerson = new Person("", "", new GregorianCalendar(2000, Calendar.FEBRUARY,8));

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            testPerson.getAge(new GregorianCalendar(1990, Calendar.FEBRUARY,8));
        });

        // Then
        assertEquals("Cannot compute age before birth", exception.getMessage());

    }







}
