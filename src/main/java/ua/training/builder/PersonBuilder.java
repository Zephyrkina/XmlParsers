package ua.training.builder;

import ua.training.entity.Person;

public class PersonBuilder {
    private String id;
    private String name;
    private String address;
    private int cash;
    private String education;

    public PersonBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setCash(int cash) {
        this.cash = cash;
        return this;
    }

    public PersonBuilder setEducation(String education) {
        this.education = education;
        return this;
    }

    public Person createPerson() {
        return new Person(id, name, address, cash, education);
    }
}