package ua.training.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import ua.training.entity.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class CreateXmlFile {

    public void createXmlFromObjectsList(List<Person> people, String outputFilePath, boolean withAllProperties) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("catalog");
            document.appendChild(rootElement);

            Element notebook = document.createElement("notebook");
            rootElement.appendChild(notebook);

            for (Person person : people) {
                if (withAllProperties) {
                    notebook.appendChild(getPerson(document, person.getId(), person.getName(), person.getAddress(), String.valueOf(person.getCash()), person.getEducation()));
                } else {
                    notebook.appendChild(getFilteredPerson(document, person.getName(), person.getAddress(), String.valueOf(person.getCash())));

                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(outputFilePath));
            transformer.transform(source, result);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Node getPerson(Document document, String id, String name, String address, String cash, String education) {
        Element person = document.createElement("person");
        person.setAttribute("id", id );
        person.appendChild(getPersonElements(document, person, "name", name));
        person.appendChild(getPersonElements(document, person, "address", address));
        person.appendChild(getPersonElements(document, person, "cash", cash));
        person.appendChild(getPersonElements(document, person, "education", education));
        return person;
    }

    private Node getFilteredPerson(Document document, String name, String address, String cash) {
        Element person = document.createElement("person");
        person.appendChild(getPersonElements(document, person, "name", name));
        person.appendChild(getPersonElements(document, person, "address", address));
        person.appendChild(getPersonElements(document, person, "cash", cash));
        return person;
    }

    private Node getPersonElements(Document document, Element element, String name, String value){
        Element node = document.createElement(name);
        node.appendChild(document.createTextNode(value));
        return node;


    }
}
