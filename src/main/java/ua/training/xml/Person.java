package ua.training.xml;

import java.util.Objects;

public class Person {
    String id;
    String name;
    String address;
    int cash;
    String education;

    public Person() {
    }

    public Person(String id, String name, String address, int cash, String education) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cash = cash;
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCash() {
        return cash;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cash == person.cash &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, cash, education);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                '}';
    }
}
