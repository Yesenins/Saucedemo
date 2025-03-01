package steps;

import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static constants.IConstants.LOGIN_PAGE_URL;

public class ProductsSteps extends BaseSteps {
    public ProductsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Add product to cart")
    public ProductsSteps addProductToCart(String... productName) {
        productsPage.addProductToCart(productName);
        return this;
    }

    @Step
    public ProductsSteps removeProduct(String... productNames) {
        productsPage.removeProduct(productNames);
        return this;
    }

    @Step
    public ProductsSteps checkButtonDisplay(String nameButton, String nameProduct) {
        if(nameButton.equals("Add")){
            Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(nameProduct));
        }
        else if(nameButton.equals("Remove")){
            Assert.assertTrue(productsPage.isRemoveButtonDisplayed(nameProduct));
        }
        return this;
    }

    @Step("Login and add product to cart")
    public ProductsSteps loginAndAddProductToCart(User user,String... productNames) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        productsPage.addProductToCart(productNames);
        return this;
    }

    @Step
    public ProductsSteps loginAndAddToCartAllProducts(User user){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user);
        productsPage.addToCartAllProducts();
        return this;
    }
}

