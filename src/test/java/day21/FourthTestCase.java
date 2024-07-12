package day21;

import java.time.Duration;
import java.util.List;
// import java.util.concurrent.TimeUnit;

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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
        }
    }

    public void allTests() {
        setUp();
        try {
            // realizo test sobre <h3>
            testLocateH3();

            // Realizo test en los inputs con la funcion testInput()
            testInput();

        } catch (Exception e) {
            e.printStackTrace(); // Manejo de cualquier excepción que ocurra durante la prueba
        } finally {
            tearDown();
        }
    }

    public void testLocateH3() {
        // Localiza el elemento <h3> usando XPath Axes
        System.out.println("Localizando el tag <h3>...");
        WebElement h3Element = driver.findElement(By.xpath("//div[@class='overlay']/child::h3"));

        // Verifica el texto del elemento <h3>
        String actualText = h3Element.getText();
        String expectedText = "Z MARKET";

        System.out.println("Verificando si el contenido del elemento <h3> es correcto...");
        if (expectedText.equals(actualText)) {
            System.out.println("Contenido: " + actualText + " es correcto");
        } else {
            throw new AssertionError("Expected: " + expectedText + ", but got: " + actualText);
        }
    }

    public void testInput() {
        // Encuentra todos los inputs dentro de divs con clase 'card__button-container'
        // usando xpath

        List<WebElement> inputs = driver
                .findElements(By.xpath("//div[@class='card__button-container']/input[@type='number']"));

        // Encuentra todos los inputs dentro de divs con clase 'card__button-container'
        // usando clase
        // List<WebElement> inputs = driver
        // .findElements(By.cssSelector("div.card__button-container >
        // input[type='number']"));

        // Esperar durante 2 segundos
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
        }
        // cantidad de inputs
        System.out.println("Checkeando cantidad de inputs presentes...");
        System.out.println("La cantidad de inputs presentes en la pagina son : " + inputs.size());

        // Itera sobre los inputs encontrados y realiza acciones con ellos
        for (WebElement input : inputs) {
            System.out.println("Valor del input antes de cambiar: " +
                    input.getAttribute("value"));
            input.clear();
            input.sendKeys("5");
            System.out.println("Valor del input después de cambiar: " +
                    input.getAttribute("value"));
        }
    }

    public void tearDown() {
        // Esperar durante 2 segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
        }
        if (driver != null) {
            System.out.println("Cerrando navegador");
            driver.quit();
        }
    }

    public static void main(String[] args) {
        FourthTestCase test = new FourthTestCase();
        test.allTests();
    }
}
