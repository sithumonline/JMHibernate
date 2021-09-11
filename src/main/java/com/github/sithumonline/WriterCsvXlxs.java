package com.github.sithumonline;

import com.opencsv.CSVWriter;

import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterCsvXlxs<T> {
    public void writeCsv(List<String[]> list) throws IOException {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        try (CSVWriter writer = new CSVWriter(new FileWriter(userDir + "/Out.csv"))) {
            writer.writeAll(list);
        }
    }
}
