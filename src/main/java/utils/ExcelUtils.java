package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    // Method to read data from Excel sheet (now maps columns to cell values)
    public static List<Map<String, Object>> readExcelData(String fileName, String sheetName) throws IOException {
        // Get InputStream for the file in resources folder
        InputStream fis = ExcelUtils.class.getClassLoader().getResourceAsStream(fileName);

        if (fis == null) {
            throw new IOException("File not found in resources: " + fileName);
        }

        // Read the Excel file
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // Get the header row
        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getPhysicalNumberOfCells();

        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        // Iterate through each row (excluding the header row)
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            Map<String, Object> rowData = new HashMap<String, Object>();

            // Map each column header to the corresponding cell value in the row
            for (int j = 0; j < colCount; j++) {
                String columnHeader = headerRow.getCell(j).getStringCellValue();
                Cell cell = row.getCell(j);
                rowData.put(columnHeader, getCellValue(cell));
            }

            // Add the row data map to the list
            data.add(rowData);
        }

        workbook.close();
        fis.close();
        return data;
    }

    // Method to extract value from a cell
    private static Object getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula(); // For formulas, return the formula
            default:
                return null;
        }
    }
}

