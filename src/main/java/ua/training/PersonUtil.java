package ua.training;

import java.util.List;
import java.util.stream.Collectors;

public class PersonUtil {
    public List<Person> filterByCash(final int cashBiggerThan, List<Person> people){
        return people.stream().filter(p -> p.getCash() >= cashBiggerThan).collect(Collectors.toList());

    }
    public void writeToConsole(List<Person> people){
        for(Person person : people){
            System.out.println(person.toString());
        }
    }
}
