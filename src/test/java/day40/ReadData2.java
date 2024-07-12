package day40;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData2 {

    public static void main(String[] args) {
        String filePath = "testData/Books.xlsx";

        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            System.out.println("total number of rows: " + rows);

            int cells = sheet.getRow(1).getLastCellNum();
            System.out.println("total number of cells: " + cells);

            for (int r = 0; r <= rows; r++) {
                XSSFRow currentRow = sheet.getRow(r);
                for (int c = 0; c < cells; c++) {
                    XSSFCell eachCell = currentRow.getCell(c);
                    System.out.print(eachCell.toString() + "\t");
                }
                System.out.println();
            }

            workbook.close();
            file.close();

        } catch (Exception e) {
            // TODO handle exception
            e.printStackTrace();
        }

    }

}
