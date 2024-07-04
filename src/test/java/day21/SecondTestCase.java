package day21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
    public static void main(String[] args) {
        // Configurar la propiedad del WebDriver para Chrome

        // Inicializar el WebDriver
        ChromeDriver driver = new ChromeDriver();

        try {
            // Abrir la página web
            driver.get("https://n5challenge.web.app/");
            driver.manage().window().maximize();

            Thread.sleep(1000);
            // Encontrar todos los elementos <img>
            List<WebElement> imgElements = driver.findElements(By.tagName("img"));

            // Obtener el número de elementos <img>
            System.out.println("Contando img tags...");
            int countImgElements = imgElements.size();
            System.out.println("Número de elementos <img>: " + countImgElements);

            // Contador para el atributo alt
            int altCount = 0;
            // Iterar sobre los elementos <img> y obtener el atributo alt
            System.out.println("Obteniendo atributo alt...");
            for (WebElement img : imgElements) {
                String altText = img.getAttribute("alt");
                System.out.println("Alt text: " + altText);

                if (altText != null && !altText.isEmpty()) {
                    altCount++;
                }
            }
            // Mostrar la cantidad total de atributos alt encontrados
            System.out.println("Total de atributos alt encontrados: " + altCount);
            //

            //
            // Buscar todos los elementos <h3> en la página
            List<WebElement> elements = driver.findElements(By.tagName("h3"));
            System.out.println("Obteniendo texto del <h3>...");
            // Verificar si existe algún elemento <h3> con texto "z market"
            boolean found = false;
            for (WebElement element : elements) {
                if (element.getText().equals("Z MARKET")) {
                    found = true;
                    break;
                }
            }

            // Imprimir el resultado
            if (found) {
                System.out.println("El elemento <h3> con texto 'z market' existe en la página.");
            } else {
                System.out.println("El elemento <h3> con texto 'z market' no existe en la página.");
            }

            //

            WebElement addProductLink = driver
                    .findElement(By.xpath("//a[@class='header__link' and text()='Agregar Producto']"));

            // Esperar un momento para que carguen los elementos (opcional)
            Thread.sleep(2000);

            // Haz clic en el enlace "Agregar Producto"
            addProductLink.click();
            System.out.println("Click realizado en el enlace 'Agregar Producto'.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Cerrando navegador...");
            // Cierra el navegador al finalizar
            driver.quit();
        }
    }
}