package ua.training.xml;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.entity.Person;
import ua.training.parser.CreateXmlFile;
import ua.training.parser.StAXParser;

import java.util.ArrayList;
import java.util.List;

public class StAXParserTest {
    private static StAXParser stAXParser;
    private static List<Person> personList;
    private static List<Person> parsedPeople;
    private static final String path = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\src\\test\\resources\\testStax.xml";

/*
    private static final String path = "/Users/zephyrkina/IdeaProjects/XmlParsers/src/test/resources/testStax.xml";
*/

    @BeforeClass
    public static void setUp() {
        parsedPeople = new ArrayList<>();
        personList = new ArrayList<>();

        Person person1 = new Person("5", "Anna", "ddd", 1234, "gfdsdfg");
        Person person2 = new Person("6", "Anna2", "ddddd", 12554, "gfdsdfg");
        Person person3 = new Person("7", "Anna3", "dd", 7234, "gfdsdfg");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        CreateXmlFile createXmlFile = new CreateXmlFile();
        createXmlFile.createXmlFromObjectsList(personList, path, true);
        stAXParser = new StAXParser();
    }

    @Test
    public void testIfParsedPeopleListSizeEqualsToActualPeopleList() {
        parsedPeople = stAXParser.parseToCollection(path);
        Assert.assertEquals(parsedPeople.size(), personList.size());
    }

    @Test
    public void testIfParsedObjectsAreEqualToActualObjects() {
        for(int i = 0; i < parsedPeople.size(); i++) {
            Assert.assertEquals(parsedPeople.get(i), personList.get(i));
        }
    }
}