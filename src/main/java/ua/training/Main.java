package ua.training;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreateXmlFile createXmlFile = new CreateXmlFile();
        PersonUtil personUtil = new PersonUtil();
        DomParser domParser = new DomParser();


        createXmlFile.create("C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\people.xml");

        File inputFile = new File("C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\people.xml");

        domParser.parseToConsole(inputFile);
        List<Person> people = domParser.parseToCollection(inputFile);

        List<Person> filteredPeople = personUtil.filterByCash(10000, people);
        personUtil.writeToConsole(filteredPeople);

        createXmlFile.createXmlFromObjectsList(filteredPeople, "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\peopleWCashUpper10000.xml");




    }
}
