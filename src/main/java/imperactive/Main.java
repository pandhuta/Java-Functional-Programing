package imperactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static imperactive.Main.Gender.FEMALE;
import static imperactive.Main.Gender.MALE;

public class Main {

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        Collection<Person> people = Arrays.asList( // Arrays.asList ini pengganti List.of
                new Person("Dhuta", MALE),
                new Person("Reyhan", MALE),
                new Person("Reyhan", MALE),
                new Person("Irin", FEMALE),
                new Person("Yanti", FEMALE),
                new Person("Nanik", FEMALE)
        );

        System.out.println("Pendekatan Imperativ");
        // Imperative approach, Pendekatan Imperativ
        List<Person> females = new ArrayList<>();

        for (Person person : people)
            if (FEMALE.equals(person.gender)) {
                females.add(person);

            }

        for (Person female : females) {
            System.out.println(female);

        }

        System.out.println("Pendekatan Declarativ");
        // Model 1
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Model 2
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                //.collect(Collectors.toList())
                .forEach(System.out::println);

        // Model 3
        List<Person> femalesw = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        //.forEach(System.out::println);
        femalesw.forEach(System.out::println);

        /*ini merupakan output yg sama tetapi memunculkan output yg sama
        yg membedakan adalah "CLEAN CODE AND SIMPLE CODE"*/

    }
}