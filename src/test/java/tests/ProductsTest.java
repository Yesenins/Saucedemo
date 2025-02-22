package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productsPage.addToCart("Product name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Mane")
    //cartPage.getPrice("Product Mane")
    //Assertions

    @Test(description = "check if the add to cart button is displayed")
    public void isAddToCartButtonDisplayedTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test(description = "check if the remove from cart button is dis")
    public void isRemoveButtonDisplayedTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
