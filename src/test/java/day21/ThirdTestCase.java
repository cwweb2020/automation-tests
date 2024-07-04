package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ThirdTestCase {

    private WebDriver driver;

    @Before
    public void setUp() {

        // Configura la ubicación del driver de Chrome
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://n5challenge.web.app/");
        driver.manage().window().maximize();

        // Esperar durante 1 segundo
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
        }
    }

    @Test
    public void testLocateH3() {
        // Localiza el elemento <h3> usando XPath Axes
        System.out.println("Localizando el tag <h3>...");
        WebElement h3Element = driver.findElement(By.xpath("//div[@class='overlay']/child::h3"));

        // Verifica el texto del elemento <h3>
        assertEquals("Z MARKET", h3Element.getText());
        System.out.println("Verificando si el contenido es correcto...");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
