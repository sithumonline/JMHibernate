package com.github.sithumonline;

import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
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

    public void writeXlxs(Map<String, Object[]> data) throws IOException {
        File excel = new File(userDir + "/Out.xlsx");
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Nexter Data");
        Set<String> newRows = data.keySet();
        int rownum = sheet.getLastRowNum();

        for (String key : newRows) {
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

        FileOutputStream os = new FileOutputStream(excel);
        book.write(os);
        System.out.println("Writing on XLSX file Finished ...");
        book.close();

    }

}
