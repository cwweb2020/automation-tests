package day40;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class WriteDataInExcel {

    public static void main(String[] args) {
        String excelFilePath = "testData/Books.xlsx"; // Ruta del archivo Excel

        try (FileInputStream file = new FileInputStream(new File(excelFilePath));
                Workbook workbook = WorkbookFactory.create(file)) {

            // Obtener la primera hoja (Sheet) del libro
            Sheet sheet = workbook.getSheetAt(0); // Hoja número 1 (índice 0)

            // Agregar nueva fila para escribir datos
            Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);

            // Datos a escribir en la nueva fila
            List<Object> rowData = new ArrayList<>();
            rowData.add("Javascript");
            rowData.add("Claude");
            rowData.add(29.99);
            rowData.add("Argentina");

            int cellIndex = 0;
            for (Object field : rowData) {
                Cell cell = newRow.createCell(cellIndex++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                }
                // También puedes manejar otros tipos de datos aquí si es necesario
            }

            // Guardar los cambios en el archivo Excel
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Datos escritos correctamente en el archivo Excel!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
