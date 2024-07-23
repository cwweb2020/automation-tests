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
        options.addArguments("--disable-bundled-ppapi-flash");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-flash-3d");
        options.addArguments("--disable-3d-apis");
        options.addArguments("--disable-plugins");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Acceder a la URL
        driver.get("https://n5challenge.web.app/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Cerrar el navegador al finalizar todas las pruebas
        }
    }

    @Test
    public void testCountAndPrintH2Tags() {
        try {
            // Contar y capturar los elementos <h2>
            System.out.println("verificando la cantidad de tags <h2>");
            int count = driver.findElements(By.tagName("h2")).size();
            System.out.println("Cantidad de tags h2 en la página: " + count);

            // Capturar y imprimir el contenido de los elementos <h2>
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
        try {
            // Locate image
            WebElement imgElement = driver
                    .findElement(By.xpath("//section[@class='banner']/descendant::img[@data-testid='img-banner']"));

            // Verify is img is present
            boolean isImageDisplayed = imgElement.isDisplayed();

            System.out.println("verificando si la imagen se encuentra presente...");

            // Assert para verificar si la imagen está presente
            Assert.assertTrue(isImageDisplayed, "La imagen no está presente en la página");

            // Imprimir mensajes indicando el resultado de la verificación
            if (isImageDisplayed) {
                System.out.println("Verificación: Imagen presente en la página");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
