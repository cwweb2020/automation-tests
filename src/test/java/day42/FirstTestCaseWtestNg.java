package day42;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
// import org.junit.Test;
import org.testng.annotations.BeforeClass;

public class FirstTestCaseWtestNg {

    // 31:34
    // @Test
    // void openApp() {
    // System.out.println("open app");
    // }

    // @Test(dependsOnMethods = "openApp")
    // void testH3() {
    // System.out.println("test");
    // }

    // @Test(dependsOnMethods = "testH3")
    // void endTest() {
    // System.out.println("finish");
    // }

    @BeforeClass
    void primero() {
        System.out.println("se ejecuta primero");
    }

    @AfterClass
    void ultimo() {
        System.out.println("se ejecuta ultimo");
    }

    @Test
    void openApp() {
        System.out.println("open app");
    }

    @Test(priority = 2)
    void testH3() {
        System.out.println("test");
    }

    @Test(priority = 3)
    void endTest() {
        System.out.println("finish");
    }

}
