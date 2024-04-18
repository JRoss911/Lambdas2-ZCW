package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {
    private static int age;

    public Person() {
        today = LocalDate.now();
    }

    public void setAge(LocalDate today, LocalDate birthday) {
        //LocalDate l = LocalDate.of(1992, 12, 24); //specify year, month, date directly
        //LocalDate today = LocalDate.now(); //gets localDate
        //  System.out.println(age.getYears() + "years" + age.getMonths() + "months" + age.getDays() + "days");
        Period.between(birthday, today);
    }

    public int getAge(LocalDate birthday) {

        if (birthday == null) {
            return 0; // Handle case where birthday is not set
        }
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today).getYears();
    }


    public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    }

    public LocalDate getBirthday() {

        return birthday;
    }

    public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    }

    public String getEmailAddress(){

        return emailAddress;
    }


    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    LocalDate today;

    public void printPerson() {
        System.out.println();
    }

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }


        }
    }

    public static void main(String[] args) {
    System.out.println(age);
    }
}

