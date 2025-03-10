package com.automation.utils;

import com.automation.base.BaseTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel File dynamically from config.properties
    public static void loadExcel(String sheetName) {
        try {
            String filePath = BaseTest.prop.getProperty("excelFilePath"); // Fetch path from config
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get Data from Excel with proper handling of String & Numeric values
    public static String getCellData(int rowNum, int colNum) {
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        
        if (cell == null) return ""; // Return empty string if cell is null
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // Convert number to String
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    // Get Row Count
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Close Excel File
    public static void closeExcel() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
