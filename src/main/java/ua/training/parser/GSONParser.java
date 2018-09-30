package ua.training.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.training.entity.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GSONParser {

    public List<Currency> parseToCollection(String jsonMessage) {
        List<Currency> currencyList = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Currency>>(){}.getType();
            Collection<Currency> enums = gson.fromJson(jsonMessage, collectionType);

            currencyList.addAll(enums);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}
