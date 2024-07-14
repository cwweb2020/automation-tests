package day42;

import java.time.Duration;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orangeHRMTTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configuración del WebDriver y opciones del navegador

        ChromeOptions options = new ChromeOptions();
        // Configuración para limpiar el caché y las cookies
        options.addArguments("--disable-bundled-ppapi-flash");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-flash-3d");
        options.addArguments("--disable-3d-apis");
        options.addArguments("--disable-plugins");

        driver = new ChromeDriver(options);

    }

    @Test
    public void testCountAndPrintH2Tags() {
        try {
            // Acceder a la URL
            driver.get("https://n5challenge.web.app/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Espera implícita de 10 segundos
            driver.manage().window().maximize();

            // Contar y capturar los elementos <h2>
            System.out.println("verificando la cantidad de tags <h2>");
            int count = driver.findElements(By.tagName("h2")).size();
            System.out.println("Cantidad de tags h2 en la página: " + count);

            // Capturar y imprimir el contenido de los elementos <h3>
            System.out.println("imprimiendo contenido de los tags <h2>");
            for (WebElement element : driver.findElements(By.tagName("h2"))) {
                System.out.println("Contenido de h2: " + element.getText());
            }

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la traza de la excepción en caso de error
        }
    }

    @Test
    public void testImagePresence() {

        // Localizar la imagen dentro del section usando su atributo data-testid
        // WebElement imgElement = driver.findElement(By.cssSelector("section.banner
        // img[data-testid='img-banner']"));

        WebElement imgElement = driver
                .findElement(By.xpath("//section[@class='banner']/descendant::img[@data-testid='img-banner']"));

        // Verificar si la imagen está presente
        boolean isImageDisplayed = imgElement.isDisplayed();

        // Assert para verificar si la imagen está presente
        Assert.assertTrue(isImageDisplayed, "La imagen no está presente en la página");

        // Imprimir mensajes indicando el resultado de la verificación
        if (isImageDisplayed) {
            System.out.println("Verificación: Imagen presente en la página");
        } else {
            System.out.println("Verificación: Imagen NO presente en la página");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cerrar el navegador al finalizar todas las pruebas
        }
    }
}
