package ua.training;

import ua.training.json.Currency;
import ua.training.json.CurrencyUtil;
import ua.training.json.GSONParser;
import ua.training.xml.*;

import java.util.List;

public class Main {
    //win
        /* static String PATH_NAME_FOR_PEOPLE = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\people.xml";
        static String PATH_NAME_FOR_FILTERED_PEOPLE = "C:\\Users\\Valeriia_Voinalovych\\IdeaProjects\\xmlParsers2\\peopleWCashUpper10000.xml";*/

    //mac
    static String PATH_NAME_FOR_PEOPLE = "/Users/zephyrkina/IdeaProjects/XmlParsers/people.xml";
    static String PATH_NAME_FOR_PEOPLE2 = "/Users/zephyrkina/IdeaProjects/XmlParsers/people2.xml";

    static String PATH_NAME_FOR_FILTERED_PEOPLE = "/Users/zephyrkina/IdeaProjects/XmlParsers/peopleWCashUpper10000.xml";
    static String PATH_NAME_FOR_FILTERED_PEOPLE2 = "/Users/zephyrkina/IdeaProjects/XmlParsers/people2WCashUpper10000.xml";

    static String PATH_NAME_FOR_FILTERED_CURRENCIES = "/Users/zephyrkina/IdeaProjects/XmlParsers/currencies.txt";

    public static void main(String[] args) {



       /* CreateXmlFile createXmlFile = new CreateXmlFile();
        PersonUtil personUtil = new PersonUtil();
        Parser<Person> domParser = new DomParser();
        Parser<Person> StAxParcer = new StAXParser();



        createXmlFile.create(PATH_NAME_FOR_PEOPLE);

        System.out.println("Dom parser:");
        domParser.parseToConsole(PATH_NAME_FOR_PEOPLE);
        System.out.println();
        System.out.println("Stax parser");
        StAxParcer.parseToConsole(PATH_NAME_FOR_PEOPLE);
        System.out.println();
        List<Person> people = domParser.parseToCollection(PATH_NAME_FOR_PEOPLE);
        List<Person> p2 = StAxParcer.parseToCollection(PATH_NAME_FOR_PEOPLE);

        personUtil.writeToConsole(p2);
        System.out.println();

        List<Person> filteredPeople = personUtil.filterByCash(10000, people);
        personUtil.writeToConsole(filteredPeople);

        createXmlFile.createXmlFromObjectsList(filteredPeople, PATH_NAME_FOR_FILTERED_PEOPLE);
*/


       CurrencyUtil currencyUtil = new CurrencyUtil();
        GSONParser gsonParser = new GSONParser();
        //gsonParser.parseToConsole();

        List<Currency> currencyList = gsonParser.parseToCollection();


        currencyList.forEach(currency -> System.out.println(currency));

        List<Currency> filterefCurrency = currencyUtil.extractActualCurrency(currencyList);
        System.out.println();
        filterefCurrency.forEach(currency -> System.out.println(currency));

        currencyUtil.writeToFile(filterefCurrency, PATH_NAME_FOR_FILTERED_CURRENCIES);

        currencyUtil.readFromFileToConsole(PATH_NAME_FOR_FILTERED_CURRENCIES);
    }
}
