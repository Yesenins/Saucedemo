package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    public void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
