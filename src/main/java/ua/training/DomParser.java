package ua.training;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DomParser {

    public void parseToConsole(File inputFile) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);

            NodeList nList = document.getElementsByTagName("person");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Id : "
                            + eElement.getAttribute("id"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Address : "
                            + eElement
                            .getElementsByTagName("address")
                            .item(0)
                            .getTextContent());
                    System.out.println("Cash : "
                            + eElement
                            .getElementsByTagName("cash")
                            .item(0)
                            .getTextContent());
                    System.out.println("Education : "
                            + eElement
                            .getElementsByTagName("education")
                            .item(0)
                            .getTextContent());
                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public List<Person> parseToCollection(File inputFile) {
        List<Person> people = new ArrayList<Person>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);

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


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }




}
