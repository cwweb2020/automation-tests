package day40;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropFile {

    public static void main(String[] args) {
        // creo object de properties file
        Properties propObject = new Properties();
        FileInputStream file = null;

        try {
            // location Ruta completa al archivo config.properties
            // String filePath = "testData/config.properties";
            String filePath = "testData/config.properties";

            // abrimos el file en reading mode
            file = new FileInputStream(filePath);
            // load properties file
            propObject.load(file);

            // Aquí puedes acceder a las propiedades cargadas
            String filePathWay = propObject.getProperty("filePathWay");
            String user = propObject.getProperty("user");

            System.out.println("Valor de la propiedad filePathWay: " + filePathWay);
            System.out.println("Valor de la propiedad user: " + user);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
