package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CartTest extends BaseTest{

    @Test(description = "Check opening shopping cart")
    public void checkOpeningChoppingCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickCartButton();
        Assert.assertEquals(driver.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test(description = "Check that all added items are displayed in the cart ")
    public void displayAllAddGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCartAllProducts();
        headerPage.clickCartButton();
        int quantityOfAllGoods = cartPage.getQuantityOfAllGoods();
        Assert.assertEquals(6, quantityOfAllGoods);
//        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText(),String.valueOf(quantityOfAllGoods));
    }

    @Test(description = "Check that the cart icon shows the added quantity of goods")
    public void displayTheNumberOfGoodsOnCartIconAddTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_ONESIE, SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertEquals(headerPage.getTextFromIcon(),"2");
    }

    @Test(description = "Check that the cart icon displays the correct number of items after adding and removing items")
    public void displayTheNumberOfGoodsOnCartIconRemoveTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        headerPage.clickCartButton();
        cartPage.continueShoppingButton();
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK,TEST_ALL_THE_THINGS_T_SHIRT_RED);
        headerPage.clickCartButton();
        cartPage.removeProductFromCart(SAUCE_LABS_FLEECE_JACKET,TEST_ALL_THE_THINGS_T_SHIRT_RED);
        Assert.assertEquals(headerPage.getTextFromIcon(),"1");
    }

    @Test(description = "Check that the item can be removed from the cart and it disappears after removal")
    public void displayRemoveGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT,SAUCE_LABS_FLEECE_JACKET);
        productsPage.removeProduct(SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickCartButton();
        List<String> productsListInCart = cartPage.getNamesProductsInShoppingCart();
        for (String item : productsListInCart){
            Assert.assertFalse(item.contains(SAUCE_LABS_BIKE_LIGHT));
        }
    }

    @Test(description = "Check that the name is displayed for each added item")
    public void displayNameOfGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCartAllProducts();
        List<String> allGoodsNamesList = productsPage.getNamesProducts();
        headerPage.clickCartButton();
        List<String> allGoodsNamesInCart = cartPage.getNamesProductsInShoppingCart();
        Assert.assertTrue(allGoodsNamesList.containsAll(allGoodsNamesInCart));
    }

    @Test(description = "Check that the price is displayed for each added item")
    public void displayPriceOfGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_ONESIE);
        headerPage.clickCartButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='7.99']")).getText().contains("7.99"));
    }

    @Test(description = "Check that the price without tax matches the total cost of goods")
    public void checkoutTotalPriceTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_ONESIE,SAUCE_LABS_BIKE_LIGHT);
        headerPage.clickCartButton();
        cartPage.checkoutButton();
        checkoutPage.postalInformationCompletion("Serega","Super");
        double priceOfGoods = cartPage.getPrice(SAUCE_LABS_ONESIE) + cartPage.getPrice(SAUCE_LABS_BIKE_LIGHT);
        double itemTotal = checkoutPage.getItemTotal();
        Assert.assertEquals(priceOfGoods, itemTotal);
    }
}
