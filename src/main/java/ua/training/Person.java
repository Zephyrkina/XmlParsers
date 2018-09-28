package ua.training;

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cash=" + cash +
                '}';
    }
}
