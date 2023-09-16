package com.domain.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility extends CommonUtils {

    private static final Logger logger = LogManager.getLogger(ExcelUtility.class);

    private static Workbook book;
    private static Sheet sheet;
    private static void openExcel(String filePath) {
        FileInputStream fileIS;
        try {
            fileIS = new FileInputStream(filePath);
            book = new XSSFWorkbook(fileIS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Opened excel file");
    }
    private static void loadSheet(String sheetName) {
        sheet = book.getSheet(sheetName);
        logger.info("Loaded excel sheet");
    }
    private static int rowCount() {
        logger.info("Get row count");
        return sheet.getPhysicalNumberOfRows();

    }
    private static int colsCount(int rowIndex) {
        logger.info("get column count");
        return sheet.getRow(rowIndex).getLastCellNum();
    }
    private static String cellData(int rowIndex, int colIndex) {
        logger.info("Cell data");
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }
    // return a 2D object array
    public static Object[][] excelIntoArray(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        int rows = rowCount();
        int cols = colsCount(0);

        Object[][] data = new Object[rows-1][cols];
        // iterate over rows
        for (int row = 1; row < rows; row++) {
            //iterate over cols
            for (int col = 0; col < cols; col++) {
                // store cell value in Object[][] data
                data[row - 1][col] = cellData(row, col);
            }
        }
        logger.info("excelIntoArray method");
        return data;
    }
    public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> excelMap;

        for (int row = 1; row < rowCount(); row++) {
            excelMap = new LinkedHashMap<String, String>();
            for (int c = 0; c < colsCount(row); c++) {
                excelMap.put(cellData(0, c), cellData(row, c));

            }
            list.add(excelMap);
        }
        logger.info("Excel into list of maps method");
        return list;
    }
}
