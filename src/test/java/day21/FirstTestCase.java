package day21;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// test case 
// launche browser
// open url https://www.saucedemo.com/
// open url https://n5challenge.web.app/
// validate title should be React App
// close browser

public class FirstTestCase {
  public static void main(String[] args) {
    ChromeOptions options = new ChromeOptions();
    // options.addArguments("start-maximized"); // Maximizar la ventana del
    // navegador al iniciar

    // Limpiar el caché y las cookies
    options.addArguments("--disable-bundled-ppapi-flash");
    options.addArguments("--disable-plugins-discovery");
    options.addArguments("--disable-plugins");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-gpu");
    options.addArguments("--disable-flash-3d");
    options.addArguments("--disable-3d-apis");
    options.addArguments("--disable-plugins");

    ChromeDriver driver = new ChromeDriver();

    try {
      // Navegar a la página web
      driver.get("https://n5challenge.web.app/");
      driver.manage().window().maximize();

      // Esperar durante 1 segundo
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace(); // Manejo de la excepción: puede ser logging u otro manejo según sea necesario
      }

      // Validar el título de la página
      String actualTitle = driver.getTitle();
      System.out.println("Validando título...");
      if (actualTitle.equals("React App")) {
        System.out.println("Test Passed! El título es: " + actualTitle);
      } else {
        System.out.println("Test Failed! El título no es 'React App'.");
      }

      // Validar el texto del elemento <h2>
      WebElement h2Element = driver.findElement(By.tagName("h2"));
      String h2Text = h2Element.getText();
      System.out.println("Validando texto del elemento <h2>...");
      if (h2Text.equals("Lista de Productos")) {
        System.out.println("Test Passed! El texto del elemento <h2> es: " + h2Text);
      } else {
        System.out.println("Test Failed! El texto del elemento <h2> no es 'Lista de Productos'.");
      }

      // Buscar todos los elementos <h3> en la página y verificar si existe "Z MARKET"
      System.out.println("Buscando elemento <h3> con texto 'Z MARKET'...");
      List<WebElement> elements = driver.findElements(By.tagName("h3"));
      boolean found = false;
      for (WebElement element : elements) {
        if (element.getText().equals("Z MARKET")) {
          found = true;
          break;
        }
      }
      if (found) {
        System.out.println("Test Passed! El elemento <h3> con texto 'Z MARKET' existe en la página.");
      } else {
        System.out.println("Test Failed! El elemento <h3> con texto 'Z MARKET' no existe en la página.");
      }

      // Validar el texto del enlace "Agregar Producto"
      WebElement addProductLink = driver
          .findElement(By.xpath("//a[@class='header__link' and text()='Agregar Producto']"));
      System.out.println("Validando texto del enlace 'Agregar Producto'...");
      if (addProductLink.getText().equals("Agregar Producto")) {
        System.out.println("Test Passed! El texto del enlace 'Agregar Producto' es: " + addProductLink.getText());
      } else {
        System.out.println("Test Failed! El texto del enlace 'Agregar Producto' no es 'Agregar Producto'.");
      }

      // Hacer clic en el botón "Agregar al carrito"
      System.out.println("Haciendo clic en el botón 'Agregar al carrito'...");
      driver.findElement(By.xpath("//button[text()='Agregar al carrito']")).click();

      // Esperar un momento para que aparezca el alerta
      try {
        Thread.sleep(2000); // Pausa de 2 segundos para permitir que aparezca el alerta
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // Manejar el alerta
      System.out.println("Manejando el alerta...");
      Alert alert = driver.switchTo().alert();
      String alertMessage = alert.getText();
      System.out.println("Mensaje del alerta: " + alertMessage);

      if (alertMessage.equals("Producto agregado al carrito")) {
        System.out.println("Test Passed! El mensaje del alerta es: " + alertMessage);
        System.out.println("Haciendo click en el boton aceptar de la alerta...");
      } else {
        System.out.println("Test Failed! El mensaje del alerta no es 'Producto agregado al carrito'.");
      }
      alert.accept(); // Aceptar el alerta (cierra el alerta)

    } finally {
      System.out.println("Cerrando navegador...");
      // Cerrar el navegador al finalizar
      driver.quit();
    }
  }
}