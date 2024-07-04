package day21;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FourthTestCase {
    private WebDriver driver;

    public void setUp() {
        // Configura las opciones de Chrome
        ChromeOptions options = new ChromeOptions();
        // Limpiar el caché y las cookies
        options.addArguments("--disable-bundled-ppapi-flash");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-flash-3d");
        options.addArguments("--disable-3d-apis");
        options.addArguments("--disable-plugins");

        // Configura la ubicación del driver de Chrome
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        // Configurar espera implícita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://n5challenge.web.app/");
        driver.manage().window().maximize();

        // Esperar durante 1 segundo
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
        }
    }

    public void testLocateH3() {
        setUp();
        try {
            // Localiza el elemento <h3> usando XPath Axes
            System.out.println("Localizando el tag <h3>...");
            WebElement h3Element = driver.findElement(By.xpath("//div[@class='overlay']/child::h3"));

            // Verifica el texto del elemento <h3>
            String actualText = h3Element.getText();
            String expectedText = "Z MARKET";
            // if (!expectedText.equals(actualText)) {
            // throw new AssertionError("Expected: " + expectedText + ", but got: " +
            // actualText);
            // }

            System.out.println("Verificando si el contenido es correcto...");
            if (expectedText.equals(actualText)) {
                System.out.println("Contenido: " + actualText + " es correcto");
            } else {
                throw new AssertionError("Expected: " + expectedText + ", but got: " + actualText);
            }

        } catch (Exception e) {
            e.printStackTrace(); // Manejo de cualquier excepción que ocurra durante la prueba
        } finally {
            tearDown();
        }
    }

    public void tearDown() {
        if (driver != null) {
            System.out.println("Cerrando navegador");
            driver.quit();
        }
    }

    public static void main(String[] args) {
        FourthTestCase test = new FourthTestCase();
        test.testLocateH3();
    }
}
