package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productsPage.addToCart("Product name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Mane")
    //Assertions

    @Test(description = "check if the add to cart button is displayed")
    public void isAddToCartButtonDisplayedTest() {
        loginSteps.loginAndWaitForPageOpened(Preconditions.userSuccess);
        productsSteps.checkButtonDisplay("Add",SAUCE_LABS_BOLT_T_SHIRT);
    }

    @Test(description = "check if the remove from cart button is dis")
    public void isRemoveButtonDisplayedTest() {
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess, SAUCE_LABS_BOLT_T_SHIRT);
        productsSteps.checkButtonDisplay("Remove",SAUCE_LABS_BOLT_T_SHIRT);
    }
}