package ua.training.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.training.entity.Person;
import ua.training.builder.PersonBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements XMLParser<Person> {

    public List<Person> parseToCollection(String inputFilePath) {
        List<Person> people = new ArrayList<Person>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(inputFilePath));

            NodeList nList = document.getElementsByTagName("person");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    Person person = new PersonBuilder()
                            .setName(eElement
                                    .getElementsByTagName("name")
                                    .item(0)
                                    .getTextContent())
                            .setAddress(eElement
                                    .getElementsByTagName("address")
                                    .item(0)
                                    .getTextContent())
                            .setCash(Integer.valueOf(eElement
                                    .getElementsByTagName("cash")
                                    .item(0)
                                    .getTextContent()))
                            .createPerson();
                    people.add(person);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return people;
    }




}
