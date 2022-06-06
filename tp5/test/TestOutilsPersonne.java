
import OutilsPersonne.OutilsPersonne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import persons.IPerson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestOutilsPersonne {

    @Test
    public void testMock(){
        // Mock creation
        IPerson mockPerson = mock(IPerson.class);

        // Mock utilisation
        when(mockPerson.getAge((any(GregorianCalendar.class)))).thenReturn(0);

        // Verification
        assertEquals(0, mockPerson.getAge(new GregorianCalendar(1990, Calendar.MARCH,3)));
    }

    @Test
    @DisplayName("La liste de retour contient un seul élément")
    public void getAllPersonsAgedBetween_contains_one_result()
    {
        // Given
        int expectedSize = 1;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(58);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(63);
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,60,65);

        // Then
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("La liste de retour est vide")
    public void getAllPersonsAgedBetween_empty_list()
    {
        // Given
        int expectedSize = 0;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>();

        // When
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,70,75);

        // Then
        assertEquals(expectedSize, result.size());

    }

    @Test
    @DisplayName("La liste de retour contient tous les éléments")
    public void getAllPersonsAgedBetween_contains_all()
    {
        // Given
        int expectedSize = 3;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(60);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(63);
        when(personList.get(2).getAge((any(GregorianCalendar.class)))).thenReturn(65);
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,60,65);

        // Then
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("La liste de retour contient tous les éléments respectant min = max")
    public void getAllPersonsAgedBetween_max_equals_min()
    {
        // Given
        int expectedSize = 1;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(60);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(63);
        when(personList.get(2).getAge((any(GregorianCalendar.class)))).thenReturn(65);
        // Min = Max
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,63,63);

        // Then
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("La liste de retour est vide car au dessus de la range")
    public void getAllPersonsAgedBetween_empty_above_range()
    {
        // Given
        int expectedSize = 0;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(70);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(75);
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,60,65);

        // Then
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("La liste de retour est vide car en dessous de la range")
    public void getAllPersonsAgedBetween_empty_below_range()
    {
        // Given
        int expectedSize = 0;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(20);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(30);
        ArrayList<IPerson> result = new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,60,65);

        // Then
        assertEquals(expectedSize, result.size());
    }

    @Test
    @DisplayName("Min > Max lance une erreur")
    public void getAllPersonsAgedBetween_min_greater_than_max_throws_error() {
        // Given
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>();

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Min > Max
            new OutilsPersonne().getAllPersonsAgedBetween(personList, cal,65,60);
        });

        // Then
        assertEquals("Min age should not be greater than max age", exception.getMessage());
    }

    @Test
    @DisplayName("Liste vide : doit retourner -1")
    public void getOldestPersonFromList_emptyList()
    {
        // Given
        int expectedMaxAge = -1;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<>();

        // Then
        assertEquals(expectedMaxAge, new OutilsPersonne().getOldestPersonFromList(personList, cal));
    }

    @Test
    @DisplayName("Retourne l'âge max dans une liste non vide")
    public void getOldestPersonFromList_returns_maxAge()
    {
        // Given
        int expectedMaxAge = 65;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(60);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(65);

        // Then
        assertEquals(expectedMaxAge, new OutilsPersonne().getOldestPersonFromList(personList, cal));
    }

    @Test
    @DisplayName("Retourne l'âge max malgré une valeur négative")
    public void getOldestPersonFromList_with_negative_value_returns_maxAge()
    {
        // Given
        int expectedMaxAge = 65;
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>() {{
            add(mock(IPerson.class));
            add(mock(IPerson.class));
        }};

        // When
        when(personList.get(0).getAge((any(GregorianCalendar.class)))).thenReturn(-10);
        when(personList.get(1).getAge((any(GregorianCalendar.class)))).thenReturn(65);

        // Then
        assertEquals(expectedMaxAge, new OutilsPersonne().getOldestPersonFromList(personList, cal));
    }

    @Test
    @DisplayName("Test anonymous sur la méthode getOldestPersonFromList")
    public void getOldestPerson_anonymous()
    {
        // Given
        IPerson mockedPerson = mock(IPerson.class);
        GregorianCalendar cal = new GregorianCalendar(2050, Calendar.MAY,10);
        ArrayList<IPerson> personList = new ArrayList<IPerson>();

        //When
        when(mockedPerson.getName()).thenReturn("MARTINEZ");
        when(mockedPerson.getFirstName()).thenReturn("Rémi");
        when(mockedPerson.getAge((any(GregorianCalendar.class)))).thenReturn(-1);
        personList.add(mockedPerson);

        // Then
        new OutilsPersonne().getOldestPersonFromList(personList, cal);
        assertEquals("", mockedPerson.getFirstName());
        assertEquals("", mockedPerson.getName());
    }

}
