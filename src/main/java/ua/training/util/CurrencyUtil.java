package ua.training.util;

import ua.training.entity.Currency;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyUtil {
    private static final String regex = "Російський рубль|Долар США|Євро";

    public static List<Currency> extractActualCurrency(List<Currency> allCurrencies) {
        return allCurrencies
                .stream()
                .filter(c -> c.getTxt()
                        .matches(regex)).collect(Collectors.toList());
    }

    public static void writeToFile(List<Currency> currencies, String outputFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilePath)))) {
            writer.write('[');
            for (Currency currency : currencies) {
                writer.write(currency.toString());
                writer.write(',');
            }
            writer.write(']');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileToConsole(String inputFilePath) {
        String line;
        try (BufferedReader abc = new BufferedReader(new FileReader(inputFilePath))) {
            while ((line = abc.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToConsole(List<Currency> currencies) {
        System.out.println('[');
        for (Currency currency : currencies) {
            System.out.print(currency.toString());
            System.out.println(',');
        }
        System.out.println(']');
    }

}
