package tests;

import constants.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import steps.LoginSteps;
import steps.ProductsSteps;
import waiters.Waiters;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements IConstants, ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    CheckoutPage checkoutPage;
    LoginPageFactory loginPageFactory;
    Waiters waiters;
    ProductsSteps productsSteps;
    LoginSteps loginSteps;

    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waiters = new Waiters();
        initPages();
    }

//    public void initTest(){
//        if (System.getProperty("browser").equals("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }else if(System.getProperty("browser").equals("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        initPages();
//    }

    public void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        loginSteps = new LoginSteps(driver);
        productsSteps = new ProductsSteps(driver);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
