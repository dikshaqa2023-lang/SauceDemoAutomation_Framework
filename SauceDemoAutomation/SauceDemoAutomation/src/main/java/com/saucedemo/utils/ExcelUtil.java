package com.saucedemo.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public final class ExcelUtil {
    private ExcelUtil() {}

    public static Object[][] getData(String filePath, String sheetName) {
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][columns];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Cell cell = sheet.getRow(i).getCell(j);
                    data[i - 1][j] = cell == null ? "" :
                            new DataFormatter().formatCellValue(cell);
                }
            }
            return data;
        } catch (Exception e) {
            throw new RuntimeException("Unable to read Excel data", e);
        }
    }
}
