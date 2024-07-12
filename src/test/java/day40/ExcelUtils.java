package day40;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    // Método para obtener el número de filas en una hoja / row count
    public static int getRowCount(String xlfile, int sheetIndex) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheetAt(sheetIndex);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    // Método para obtener el número de celdas en una fila específica
    public static int getCellCount(String xlfile, int sheetIndex, int rowIndex) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheetAt(sheetIndex);
        row = ws.getRow(rowIndex);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    // Método para obtener el dato de una celda específica usando el índice de la
    // hoja
    public static String getCellData(String xlfile, int sheetIndex, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(xlfile); // Abre el archivo Excel
        wb = new XSSFWorkbook(fi); // Crea un objeto de la clase XSSFWorkbook
        ws = wb.getSheetAt(sheetIndex); // Obtiene la hoja de cálculo por su índice
        row = ws.getRow(rownum); // Obtiene la fila específica
        cell = row.getCell(colnum); // Obtiene la celda específica
        String data;

        try {
            data = cell.toString(); // Convierte el valor de la celda a String
        } catch (Exception e) {
            data = ""; // Si hay una excepción, asigna una cadena vacía
        }

        wb.close(); // Cierra el workbook
        fi.close(); // Cierra el archivo
        return data; // Retorna el valor de la celda como una cadena
    }

    // Método para establecer el dato de una celda específica usando el índice de la
    // hoja
    public static void setCellData(String xlfile, int sheetIndex, int rownum, int colnum, String data)
            throws IOException {
        // Abre el archivo Excel
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);

        // Selecciona la hoja por su índice
        ws = wb.getSheetAt(sheetIndex);

        // Selecciona la fila y la celda
        row = ws.getRow(rownum);
        if (row == null) {
            row = ws.createRow(rownum);
        }
        cell = row.createCell(colnum);

        // Establece el valor de la celda
        cell.setCellValue(data);

        // Escribe los cambios en el archivo
        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        // Cierra los flujos y el workbook
        wb.close();
        fi.close();
        fo.close();
    }

    // Método para leer todos los datos de una hoja y retornarlos como una matriz
    public static String[][] readSheetData(String xlfile, int sheetIndex) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheetAt(sheetIndex);
        int rows = ws.getLastRowNum();
        int cells = ws.getRow(0).getLastCellNum();

        String[][] data = new String[rows + 1][cells];

        for (int r = 0; r <= rows; r++) {
            row = ws.getRow(r);
            for (int c = 0; c < cells; c++) {
                cell = row.getCell(c);
                data[r][c] = (cell != null) ? cell.toString() : "";
            }
        }

        wb.close();
        fi.close();
        return data;
    }
}
