package ua.training.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GSONParser {
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public void parseToConsole() {
        String json = null;
        try {
            json = readUrl("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Currency>>(){}.getType();
            Collection<Currency> enums = gson.fromJson(json, collectionType);

            for (Currency currency : enums) {
                System.out.println("    " + currency.r030);
                System.out.println("    " + currency.txt);
                System.out.println("    " + currency.rate);
                System.out.println("    " + currency.cc);
                System.out.println("    " + currency.exchangedate);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Currency> parseToCollection() {
        String json = null;
        List<Currency> currencyList = new ArrayList<>();
        try {
            json = readUrl("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Currency>>(){}.getType();
            Collection<Currency> enums = gson.fromJson(json, collectionType);


            for (Currency currency : enums) {
                currencyList.add(currency);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyList;
    }

    public List<Currency> parseToCollection(String json) {
        List<Currency> currencyList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Currency>>(){}.getType();
            Collection<Currency> enums = gson.fromJson(json, collectionType);

            currencyList.addAll(enums);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}
