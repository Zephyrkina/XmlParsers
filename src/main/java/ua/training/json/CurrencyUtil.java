package ua.training.json;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyUtil {
    List<String> actualCurrency =  Arrays.asList("Російський рубль", "Долар США", "Євро");
    String regex = "Російський рубль|Долар США|Євро";

    public List<Currency> extractActualCurrency(List<Currency> allCurrencies) {
        return allCurrencies
                .stream()
                .filter(c -> c.getTxt()
                        .matches(regex)).collect(Collectors.toList());
    }

    public void writeToFile(List<Currency> currencies, String outputFilePath) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFilePath)));

            for(Currency currency : currencies){
                writer.write(currency.toString());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readFromFileToConsole(String inputFilePath) {
        try {
            String line;
            BufferedReader abc = new BufferedReader(new FileReader(inputFilePath));
            List<String> lines = new ArrayList<String>();

            while ((line = abc.readLine()) !=null){
                lines.add(line);
                System.out.println(line);
            }
            abc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
