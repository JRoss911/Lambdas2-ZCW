package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements CheckPerson {
    private static List<Person> roster;
    private static CheckPerson tester;
    //private static int age;

    public Person() {
        today = LocalDate.now();
    }
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
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

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public boolean test(Person p) {
        return p.gender == Sex.MALE &&
                p.getAge(birthday) >= 18 &&
                p.getAge(birthday) <= 35;
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
        System.out.println("Name: " + name + " Birthday: " + birthday + " Gender: " + gender + " Email: " + emailAddress);
    }


    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        Person.roster = roster;
        Person.tester = tester;
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
//       this.name = name;
//       this.birthday = birthday;
//        this.gender = gender;
//        this.emailAddress = emailAddress;
public static class GenderDefiner implements CheckPerson { //anonymous class

    @Override
    public boolean test(Person p) {
        return switch (p.getGender()) {
            case MALE, FEMALE -> true;
            default -> false;
        };
    }

    public static class EmailDefiner implements CheckPerson {

        @Override
        public boolean test(Person p) {
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");

            try {
                Matcher matcher = pattern.matcher(p.getEmailAddress());
                if (matcher.find()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Invalid email type, please follow username@password type");
            }
            return false;
        }
}

    public static void main(String[] args) {
    Person Jorden = new Person(){

    };

    System.out.println();
    }
}
}

