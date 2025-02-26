package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    @Test(description = "Check opening shopping cart")
    public void checkOpeningChoppingCartTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD);
        headerPage.clickCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test(description = "Check that all added items are displayed in the cart ")
    public void displayAllAddGoodsTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addToCartAllProducts();
        headerPage.clickCartButton();
        Assert.assertEquals(cartPage.getProductQuantity(), 6);
    }

    @Test(description = "Check that the cart icon shows the added quantity of goods")
    public void displayTheNumberOfGoodsOnCartIconAddTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_ONESIE, SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertEquals(headerPage.getTextFromIcon(),"2");
    }

    @Test(description = "Check that the cart icon displays the correct number of items after adding and removing items")
    public void displayTheNumberOfGoodsOnCartIconRemoveTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        headerPage.clickCartButton()
                .continueShoppingButton()
                .addProductToCart(SAUCE_LABS_BACKPACK,TEST_ALL_THE_THINGS_T_SHIRT_RED);
        headerPage.clickCartButton()
                .removeProductFromCart(SAUCE_LABS_FLEECE_JACKET,TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Assert.assertEquals(headerPage.getTextFromIcon(),"1");
    }

    @Test(description = "Check that the item can be removed from the cart and it disappears after removal")
    public void displayRemoveGoodsTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT,SAUCE_LABS_FLEECE_JACKET)
                .removeProduct(SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickCartButton();
        List<String> productsListInCart = cartPage.getNamesProductsInShoppingCart();
        for (String item : productsListInCart){
            Assert.assertFalse(item.contains(SAUCE_LABS_BIKE_LIGHT));
        }
    }

    @Test(description = "Check that the name is displayed for each added item")
    public void displayNameOfGoodsTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addToCartAllProducts();
        List<String> allGoodsNamesList = productsPage.getNamesProducts();
        headerPage.clickCartButton();
        Assert.assertTrue(allGoodsNamesList.containsAll(cartPage.getNamesProductsInShoppingCart()));
    }

    @Test(description = "Check that the price is displayed for each added item")
    public void displayPriceOfGoodsTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_ONESIE);
        headerPage.clickCartButton();
        Assert.assertEquals(cartPage.getPrice(SAUCE_LABS_ONESIE), 7.99);
    }

    @Test(description = "Check that the price without tax matches the total cost of goods")
    public void checkoutTotalPriceTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickCartButton()
                .checkoutButton()
                .postalInformationCompletion("Serega","Super");
        double priceOfGoods = cartPage.getPrice(SAUCE_LABS_ONESIE) + cartPage.getPrice(SAUCE_LABS_BIKE_LIGHT);
        double itemTotal = checkoutPage.getItemTotal();
        Assert.assertEquals(priceOfGoods, itemTotal);
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
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(USERNAME,PASSWORD)
                .addProductToCart(productName);
        headerPage.clickCartButton();
        Assert.assertEquals(cartPage.getProductPriceText(productName),price);
    }

    @Test(description = "check if the specified amount of products is added to the cart")
    public void checkQuantityTest(){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME,PASSWORD)
                .addProductToCart(SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_ONESIE);
        headerPage.clickCartButton();
        Assert.assertEquals(cartPage.getProductQuantity(), 2);
    }

    @Test(description = "check if the specified item is removed from the cart")
    public void removeItemFromCartTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openCartPage(CART_PAGE_URL)
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }
}
