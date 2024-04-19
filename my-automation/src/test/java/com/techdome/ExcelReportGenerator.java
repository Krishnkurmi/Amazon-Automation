package com.techdome;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReportGenerator {

    public static void generateReport(String title, String price) {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        // Create a new sheet
        Sheet sheet = workbook.createSheet("Product Details");

        // Create a new row
        Row row = sheet.createRow(0);

        // Create cells and set values
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Product Title");

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("Product Price");

        // Create a new row
        Row dataRow = sheet.createRow(1);

        // Create cells and set values
        Cell dataCell1 = dataRow.createCell(0);
        dataCell1.setCellValue(title);

        Cell dataCell2 = dataRow.createCell(1);
        dataCell2.setCellValue(price);

        // Auto-size the columns
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        // Write the workbook to a file
        try (FileOutputStream outputStream = new FileOutputStream("report.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}