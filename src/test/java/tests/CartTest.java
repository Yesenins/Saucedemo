package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    @Test(description = "Check opening shopping cart")
    public void checkOpeningChoppingCartTest(){
        loginSteps.loginAndWaitForPageOpened(Preconditions.userSuccess);
        headerSteps.goToCart();
        cartSteps.checkSiteOpen(driver, CART_PAGE_URL);
    }

    @Test(description = "Check that the item can be removed from the cart and it disappears after removal")
    public void displayRemoveGoodsTest(){
        loginSteps.loginAndWaitForPageOpened(Preconditions.userSuccess);
        productsSteps
                .addProductToCart(SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT,SAUCE_LABS_FLEECE_JACKET)
                .removeProduct(SAUCE_LABS_BIKE_LIGHT);
        headerSteps.goToCart();
        cartSteps.verifyProductIsNotInCart(SAUCE_LABS_BIKE_LIGHT);
    }

    @Test(description = "Check that the cart icon shows the added quantity of goods")
    public void displayTheNumberOfGoodsOnCartIconAddTest(){
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess,SAUCE_LABS_ONESIE, SAUCE_LABS_BOLT_T_SHIRT);
        cartSteps.checkDisplayTheNumberOfGoodsOnCartIcon("2");
    }

    @Test(description = "Check that the cart icon displays the correct number of items after adding and removing items")
    public void displayTheNumberOfGoodsOnCartIconRemoveTest(){
        loginSteps.loginAndWaitForPageOpened(Preconditions.userSuccess);
        productsSteps.addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        headerSteps.goToCart();
        cartSteps.continueShopping();
        productsSteps.addProductToCart(SAUCE_LABS_BACKPACK,TEST_ALL_THE_THINGS_T_SHIRT_RED);
        headerSteps.goToCart();
        cartSteps.removeProductFromCart(SAUCE_LABS_FLEECE_JACKET, TEST_ALL_THE_THINGS_T_SHIRT_RED);
        cartSteps.checkDisplayTheNumberOfGoodsOnCartIcon("1");
    }

    @Test(description = "Check that the name is displayed for each added item")
    public void displayNameOfGoodsTest(){
        productsSteps.loginAndAddToCartAllProducts(Preconditions.userSuccess);
        cartSteps.checkThatTheNameIsDisplayedForEachAddedItem();
    }

    @Test(description = "Check that all added items are displayed in the cart ")
    public void displayAllAddGoodsTest(){
        productsSteps.loginAndAddToCartAllProducts(Preconditions.userSuccess);
        headerSteps.goToCart();
        cartSteps.checkThatItemsDisplayedInTheCart(6);
    }

    @Test(description = "Check that the price is displayed for each added item")
    public void displayPriceOfGoodsTest(){
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess, SAUCE_LABS_ONESIE);
        headerSteps.goToCart();
        cartSteps.checkThatThePriceDisplayedForItem(SAUCE_LABS_ONESIE,7.99);
    }

    @Test(description = "Check that the price without tax matches the total cost of goods")
    public void checkoutTotalPriceTest(){
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess,SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT);
        headerSteps.goToCart();
        cartSteps.postalInformationCompletion("Serega","Super", "12345");
        cartSteps.checkThatPriceMatchesTotalPrice();
    }

    @DataProvider(name = "products")
    public Object[][] productsAndPrices() {
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    /**
     *
     * @param productName
     * @param price
     */
    @Test(dataProvider = "products" , groups = "products", description = "")
    public void checkProductPriceInCartTest(String productName, String price){
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess, productName);
        headerSteps.goToCart();
        cartSteps.checkPrice(productName, price);
    }

    @Test(description = "check if the specified amount of products is added to the cart")
    public void checkQuantityTest(){
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess, SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_ONESIE);
        headerSteps.goToCart();
        cartSteps.checkQuantity(2);
    }

    @Test(description = "check if the specified item is removed from the cart")
    public void removeItemFromCartTest() {
        productsSteps.loginAndAddProductToCart(Preconditions.userSuccess, SAUCE_LABS_BACKPACK);
        cartSteps
                .removeProductFromCart(SAUCE_LABS_BACKPACK)
                .verifyProductIsNotInCart(SAUCE_LABS_BACKPACK);
    }
}
