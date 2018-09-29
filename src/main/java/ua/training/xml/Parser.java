package ua.training.xml;

import java.io.File;
import java.util.List;

public interface Parser<T> {
    public void parseToConsole(String inputFilePath);
    public List<T> parseToCollection(String inputFilePath);
}
