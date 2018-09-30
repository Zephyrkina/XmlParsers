package ua.training.parser;

import java.io.File;
import java.util.List;

public interface XMLParser<T> {
    public List<T> parseToCollection(String inputFilePath);
}
