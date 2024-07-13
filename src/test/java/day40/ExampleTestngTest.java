package day40;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ExampleTestngTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Setup before tests");
        // System.setProperty("webdriver.chrome.driver",
        // "C:\\drivers\\chromedriver.exe"); // Actualiza esta ruta
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Cleanup after tests");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMethod() {
        try {
            System.out.println("TestNG test method executed");
            driver.get("https://n5challenge.web.app/");
            // Tu código de prueba aquí
            // Por ejemplo, alguna interacción con la página
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            // Puedes lanzar la excepción nuevamente si quieres que TestNG marque la prueba
            // como fallida
            throw e;
        } finally {
            // Código que siempre quieres ejecutar, independientemente de si ocurre una
            // excepción
            System.out.println("TestNG test method finished");
        }
    }
}
