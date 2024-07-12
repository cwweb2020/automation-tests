package day40;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataExcel {

    public static void main(String[] args) {
        String filePath = "testData/Books.xlsx"; // Ruta del archivo Excel

        try {
            FileInputStream file = new FileInputStream(new File(filePath));

            // Crear el libro de trabajo (Workbook) desde el archivo
            Workbook workbook = WorkbookFactory.create(file);

            // Obtener la primera hoja (Sheet) del libro
            Sheet sheet = workbook.getSheetAt(0); // Hoja número 1 (índice 0)

            // Iterar sobre las filas de la hoja
            for (Row row : sheet) {
                // Iterar sobre las celdas de cada fila
                for (Cell cell : row) {
                    // Determinar el tipo de celda y obtener su contenido
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("[" + cell.getCellType() + "]\t");
                    }
                }
                System.out.println(); // Nueva línea después de cada fila
            }

            // Cerrar el libro de trabajo y liberar recursos
            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
