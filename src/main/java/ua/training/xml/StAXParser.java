package ua.training.xml;

import ua.training.xml.Parser;
import ua.training.xml.Person;
import ua.training.xml.PersonBuilder;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StAXParser implements Parser<Person> {


    @Override
    public void parseToConsole(String inputFilePath) {
        boolean bName = false;
        boolean bAddress = false;
        boolean bCash = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(inputFilePath));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("person")) {
                            System.out.println("Start Element : person");
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String rollNo = attributes.next().getValue();
                            System.out.println("Id: " + rollNo);
                        } else if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase("address")) {
                            bAddress = true;
                        } else if (qName.equalsIgnoreCase("cash")) {
                            bCash = true;
                        }

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bName) {
                            System.out.println("Name: " + characters.getData());
                            bName = false;
                        }
                        if(bAddress) {
                            System.out.println("Address: " + characters.getData());
                            bAddress = false;
                        }
                        if(bCash) {
                            System.out.println("Cash: " + characters.getData());
                            bCash = false;
                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("person")) {
                            System.out.println("End Element : person");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Person> parseToCollection(String inputFilePath) {
        List<Person> people = new ArrayList<>();
        Person person;
        boolean bName = false;
        boolean bAddress = false;
        boolean bCash = false;
        String name;
        String address;
        int cash;
        PersonBuilder personBuilder = new PersonBuilder();

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(inputFilePath));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();


                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("person")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
/*
                            String id = attributes.next().getValue();
*/
                        } else if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase("address")) {
                            bAddress = true;
                        } else if (qName.equalsIgnoreCase("cash")) {
                            bCash = true;
                        }

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bName) {
                            name = characters.getData();
                            personBuilder.setName(name);
                            bName = false;
                        }
                        if(bAddress) {
                            address = characters.getData();
                            personBuilder.setAddress(address);
                            bAddress = false;
                        }
                        if(bCash) {
                            cash = Integer.valueOf(characters.getData());
                            personBuilder.setCash(cash);
                            bCash = false;
                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("person")) {
                            person = personBuilder.createPerson();
                            people.add(person);
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return people;
    }

}
