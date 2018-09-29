package ua.training.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GSONParserTest {
    GSONParser gsonParser;
    String message;
    List<Currency> currencies = new ArrayList<>();

    @Before
    public void setup(){
        Currency currency1 = new Currency("12", "Dollar", "4.42222", "USD", "01.10.2018");
        Currency currency2 = new Currency("142", "Dollar2", "4.42222", "UD", "01.10.2018");
        Currency currency3 = new Currency("1442", "Dollar3", "4.42222", "USDF", "01.10.2018");
        currencies.add(currency1);
        currencies.add(currency2);
        currencies.add(currency3);

        JSONObject json = new JSONObject();

        JSONArray array = new JSONArray();
        JSONObject item1 = new JSONObject();
        item1.put("r030", "12");
        item1.put("txt", "Dollar");
        item1.put("rate","4.42222");
        item1.put("cc","USD");
        item1.put("exchangedate", "01.10.2018");


        array.put(item1);

        JSONObject item2 = new JSONObject();
        item2.put("r030", "142");
        item2.put("txt", "Dollar2");
        item2.put("rate","4.42222");
        item2.put("cc","UD");
        item2.put("exchangedate", "01.10.2018");

        array.put(item2);

        JSONObject item3 = new JSONObject();
        item3.put("r030", "1442");
        item3.put("txt", "Dollar3");
        item3.put("rate","4.42222");
        item3.put("cc","USDF");
        item3.put("exchangedate", "01.10.2018");

        array.put(item3);

        /*json.put("", array);*/
       /* json.put(item1);
        json.put(item2);
*/
        message = array.toString();
/*
        message = json.toString();
*/
        System.out.println(message);
        gsonParser = new GSONParser();
    }

    @Test
    public void testGSONParser() {
        List<Currency> currencyList = gsonParser.parseToCollection(message);
        Assert.assertEquals(currencyList.size(), currencies.size());
        for(int i = 0; i < currencyList.size(); i++) {
            System.out.println(currencyList.get(i));
            System.out.println(currencies.get(i));

            Assert.assertEquals(currencyList.get(i), currencies.get(i));
        }
    }
}