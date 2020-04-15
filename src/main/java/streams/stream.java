package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams.stream.PersonStream.GenderPerson.FEMALE;
import static streams.stream.PersonStream.GenderPerson.MALE;

public class stream {
    static class PersonStream {
        private final String name;
        private final GenderPerson genderPerson;

        public PersonStream(String name, GenderPerson gender) {
            this.name = name;
            this.genderPerson = gender;
        }

        @Override
        public String toString() {
            return "PersonStream{" +
                    "name='" + name + '\'' +
                    ", genderPerson=" + genderPerson +
                    '}';
        }

        enum GenderPerson {
            MALE,
            FEMALE
        }

        public static void main(String[] args) {
            Collection<PersonStream> people = Arrays.asList( // Arrays.asList ini pengganti List.of
                    new PersonStream("Dhuta", MALE),
                    new PersonStream("Irin", FEMALE),
                    new PersonStream("Yanti", FEMALE),
                    new PersonStream("Nanik", FEMALE)
            );

            // Model 1
            people.stream()
                    .map(personStream -> personStream.genderPerson)
                    .collect(Collectors.toSet())
                    .forEach(System.out::println);

            // Model 2
            people.stream()
                    .map(personStream -> personStream.name)
                    .mapToInt(String::length)
                    .forEach(System.out::println);

            // ctrl + alt + v untuk membuat dr personStream -> FEMALE.equals(personStream.genderPerson)
            // Model 3
            Predicate<PersonStream> personStreamPredicate = personStream -> FEMALE.equals(personStream.genderPerson);
            boolean containsOnlyFemales =  people.stream()
                    .allMatch(personStreamPredicate);

           // Model 4
            boolean containsOnlyFemalesV2 =  people.stream()
                    .anyMatch(personStreamPredicate);

            System.out.println(containsOnlyFemales);
        }

    }
}
