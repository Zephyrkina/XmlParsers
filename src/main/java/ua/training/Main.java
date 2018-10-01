package ua.training;

import ua.training.entity.Currency;
import ua.training.entity.Person;
import ua.training.parser.*;
import ua.training.util.CurrencyUtil;
import ua.training.util.PersonUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PATH_NAME_FOR_PEOPLE = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\src\\main\\resources\\people.xml";
    private static final String PATH_NAME_FOR_FILTERED_PEOPLE = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\src\\main\\resources\\peopleWCashUpper10000.xml";

    private static final String PATH_NAME_FOR_FILTERED_CURRENCIES = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\src\\main\\resources\\currencies.txt";
    private static final String jsonUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";


  /*  private static final String PATH_NAME_FOR_PEOPLE = "/Users/zephyrkina/IdeaProjects/XmlParsers/src/main/resources/people.xml";
    private static final String PATH_NAME_FOR_FILTERED_PEOPLE = "/Users/zephyrkina/IdeaProjects/XmlParsers/src/main/resources/peopleWCashUpper10000.xml";
    private static final String PATH_NAME_FOR_FILTERED_CURRENCIES = "/Users/zephyrkina/IdeaProjects/XmlParsers/src/main/resources/currencies.txt";
    private static final String jsonUrl = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";*/

    public static void main(String[] args) {

        //XML

        CreateXmlFile createXmlFile = new CreateXmlFile();
        XMLParser<Person> domParser = new DomParser();
        XMLParser<Person> StAxParser = new StAXParser();

        List<Person> personList = new ArrayList<>();

        Person person1 = new Person("1", "Anna", "ddd", 99834, "gfdsdfg");
        Person person2 = new Person("2", "Anna2", "ddddd", 1254, "gfdsdfg");
        Person person3 = new Person("3", "Anna3", "dd", 79934, "gfdsdfg");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        createXmlFile.createXmlFromObjectsList(personList, PATH_NAME_FOR_PEOPLE, true);

        List<Person> people = domParser.parseToCollection(PATH_NAME_FOR_PEOPLE);
        List<Person> p2 = StAxParser.parseToCollection(PATH_NAME_FOR_PEOPLE);

        PersonUtil.writeToConsole(p2);

        List<Person> filteredPeople = PersonUtil.filterByCash(10000, people);
        PersonUtil.writeToConsole(filteredPeople);

        createXmlFile.createXmlFromObjectsList(filteredPeople, PATH_NAME_FOR_FILTERED_PEOPLE, false);


        //JSON

        JSONToStringParser jsonToStringParser = new JSONToStringParser();
        GSONParser gsonParser = new GSONParser();
        String message = jsonToStringParser.readStringFromJson(jsonUrl);

        List<Currency> currencyList = gsonParser.parseToCollection(message);

        CurrencyUtil.writeToConsole(currencyList);

        List<Currency> filteredCurrency = CurrencyUtil.extractActualCurrency(currencyList);

        CurrencyUtil.writeToConsole(filteredCurrency);

        CurrencyUtil.writeToFile(filteredCurrency, PATH_NAME_FOR_FILTERED_CURRENCIES);

        CurrencyUtil.readFromFileToConsole(PATH_NAME_FOR_FILTERED_CURRENCIES);
    }
}
