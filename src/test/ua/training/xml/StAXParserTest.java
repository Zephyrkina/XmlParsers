package ua.training.xml;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StAXParserTest {

    StAXParser stAXParser;
    CreateXmlFile createXmlFile;
    List<Person> personList = new ArrayList<>();
    String path = "/Users/zephyrkina/IdeaProjects/XmlParsers/testStax.xml";

    @Before
    public void setup() {
        Person person1 = new Person("5", "Anna", "ddd", 1234, "gfdsdfg");
        Person person2 = new Person("6", "Anna2", "ddddd", 12554, "gfdsdfg");
        Person person3 = new Person("7", "Anna3", "dd", 7234, "gfdsdfg");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        createXmlFile = new CreateXmlFile();
        createXmlFile.createXmlFromObjectsList(personList, path);
        stAXParser = new StAXParser();
    }

    @Test
    public void testDomParcer() {
        List<Person> parsedPeople = stAXParser.parseToCollection(path);
        Assert.assertEquals(parsedPeople.size(), personList.size());
        for(int i = 0; i < parsedPeople.size(); i++) {
            Assert.assertEquals(parsedPeople.get(i), personList.get(i));
        }
    }
}