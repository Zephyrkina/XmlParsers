package ua.training.util;

import ua.training.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonUtil {
    public static List<Person> filterByCash(final int cashBiggerThan, List<Person> people){
        return people.stream().filter(p -> p.getCash() >= cashBiggerThan).collect(Collectors.toList());

    }
    public static void writeToConsole(List<Person> people){
        for(Person person : people){
            System.out.println(person.toString());
        }
    }
}
