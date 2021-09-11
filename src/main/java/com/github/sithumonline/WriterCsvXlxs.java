package com.github.sithumonline;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WriterCsvXlxs {
    private String userDir = System.getProperty("user.dir");

    public void writeCsv(List<String[]> list) throws IOException {
        System.out.println(userDir);
        try (CSVWriter writer = new CSVWriter(new FileWriter(userDir + "/Out.csv"))) {
            writer.writeAll(list);
        }
    }

    public void writeXlxs() throws IOException {
        File excel = new File(userDir + "/Out.xlsx");
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Nexter Data");

        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("7", new Object[]{7d, "Sonya", "75K", "SALES", "Rupert"});
        data.put("8", new Object[]{8d, "Kris", "85K", "SALES", "Rupert"});
        data.put("9", new Object[]{9d, "Dave", "90K", "SALES", "Rupert"});

        // Set to Iterate and add rows into XLS file
        Set<String> newRows = data.keySet();

        // get the last row number to append new data
        int rownum = sheet.getLastRowNum();

        for (String key : newRows) {

            // Creating a new Row in existing XLSX sheet
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }

        // open an OutputStream to save written data into XLSX file
        FileOutputStream os = new FileOutputStream(excel);
        book.write(os);
        System.out.println("Writing on XLSX file Finished ...");
        book.close();

    }

}
