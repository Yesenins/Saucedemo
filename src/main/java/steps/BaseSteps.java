package steps;

import org.openqa.selenium.WebDriver;
import pages.*;
import waiters.Waiters;

public class BaseSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    HeaderPage headerPage;
    CheckoutPage checkoutPage;
    LoginPageFactory loginPageFactory;
    Waiters waiters;

    public BaseSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        waiters = new Waiters();
    }
}