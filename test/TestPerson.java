package test;

import main.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Period;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
class TestPerson {


    @Test
    public void setAgeTest() {

        // Given
        Person person = new Person();
        LocalDate birthday = LocalDate.of(1992, 12, 24);
        LocalDate today = LocalDate.now();
        // When
        person.setAge(birthday, today);

        // Then
        int actualAge = person.getAge(birthday);
        int expectedAge = Period.between(birthday, today).getYears();
        assertEquals(expectedAge, actualAge);
    }


    @Test
    public void setBirthdayTest() {

        // Given
        Person person = new Person();
        LocalDate birthday = LocalDate.of(1992, 12, 24);
        // When
        person.setBirthday(birthday);

        // Then
        assertEquals(birthday, person.getBirthday());
    }

    @Test
    public void setEmailAddressTest() {
    // Given
        Person person = new Person();
        String expected = "JRoss9117@gmail.com";
        // When
        person.setEmailAddress(expected);
        // Then
        String actual = person.getEmailAddress();

        Assertions.assertEquals(expected, actual);
    }
}



